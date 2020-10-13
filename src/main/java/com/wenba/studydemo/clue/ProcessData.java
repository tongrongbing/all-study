package com.wenba.studydemo.clue;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author：tongrongbing
 * @date：created in 2020/9/29 1:44 下午
 * @description：
 */
public class ProcessData {
    public static void main(String[] args) throws Exception {
        ProcessData data = new ProcessData();
        data.execute();
    }

    public void execute() throws InterruptedException, SQLException, ClassNotFoundException {
        // 计时
        long t1 = System.currentTimeMillis();
        // 最大数量
        Integer count = 3198850;
        // 每批次处理最大数量
        final Integer size = 50000;
        // 获取批次数量
        Integer maxPageNo = count / size;
        maxPageNo = count % size == 0 ? maxPageNo : maxPageNo + 1;
        // 线程池
        ThreadPoolTaskExecutor executor = threadPoolTaskExecutor();
        // 闭锁 用于统计总耗时
        CountDownLatch cdl = new CountDownLatch(maxPageNo);
        // 信号量 确保运行期间饱负荷使用cpu
        Semaphore semaphore = new Semaphore(executor.getMaxPoolSize());
        List<Connection> connections = getConns(maxPageNo);
        List<Connection> connectionWrites = getWriteConns(maxPageNo);
        for (int i = 0; i < maxPageNo; i++) {
            final int pageNo = i;
            // 获取可执行信号
            semaphore.acquire();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        saveBatch(connectionWrites.get(pageNo), getData(connections.get(pageNo), pageNo, size));
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        System.out.println(Thread.currentThread().getId() + " 执行... " + (pageNo* size) + " -- " + ((pageNo+1) * size) + "完成");
                        // 是否信号量
                        semaphore.release();
                        cdl.countDown();
                    }
                }
            });
        }
        cdl.await(2, TimeUnit.MINUTES);
        System.out.println((System.currentTimeMillis() - t1));
    }

    /**
     * 线程池初始化
     * @return
     */
    private ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        int cpuCount = 4;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
//        executor.setCorePoolSize(Math.max(2, Math.min(cpuCount - 1, 3)));
        executor.setCorePoolSize(cpuCount * 2 + 1);
        executor.setMaxPoolSize(cpuCount * 2 + 1);
        executor.setQueueCapacity(1);
        executor.setKeepAliveSeconds(30);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    private List<Connection> getConns(int count) throws ClassNotFoundException, SQLException {
        List<Connection> list = new ArrayList<>();
        Connection conn = null;//声明连接对象
        String driver = "com.mysql.jdbc.Driver";// 驱动程序类名
        String url = "jdbc:mysql://10.21.93.218:3306/fudao_crm_clue?" // 数据库URL
                + "useUnicode=true&characterEncoding=UTF8";// 防止乱码
        Class.forName(driver);// 注册(加载)驱动程序
        for(int i=0;i<count;i++){
            list.add(DriverManager.getConnection(url, "wenba", "123456"));// 获取数据库连接
        }
        return list;
    }

    private List<Connection> getWriteConns(int count) throws ClassNotFoundException, SQLException {
        List<Connection> list = new ArrayList<>();
        String driver = "com.mysql.jdbc.Driver";// 驱动程序类名
        String url = "jdbc:mysql://10.21.93.218:3306/test?" // 数据库URL
                + "useUnicode=true&characterEncoding=UTF8&rewriteBatchedStatements=true";// 防止乱码
        Class.forName(driver);// 注册(加载)驱动程序
        for(int i=0;i<count;i++){
            list.add(DriverManager.getConnection(url, "wenba", "123456"));// 获取数据库连接
        }
        return list;
    }
    /**
     * 查询db
     * @param pageNo
     * @param pageSize
     * @return
     */
    private List<ClueData> getData(Connection conn, Integer pageNo, Integer pageSize){
        List<ClueData> res = new ArrayList<>();
        try {
            System.out.println(Thread.currentThread().getId() + " 执行... " + (pageNo* pageSize) + " -- " + ((pageNo+1) * pageSize));
            try {
                System.out.println("查询数据....................");
                String sql = "SELECT id,name,phone_no,activity_phone,linkman_phone,weixin,qq,sex,junjun_uid,city from fudao_crm_clue LIMIT ?,?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,pageNo);
                pstmt.setInt(2,pageSize);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String phone_no = rs.getString(3);
                    String activity_phone = rs.getString(4);
                    String linkman_phone = rs.getString(5);
                    String weixin = rs.getString(6);
                    String qq = rs.getString(7);
                    int sex = rs.getInt(8);
                    int junjun_uid = rs.getInt(9);
                    /*String city = rs.getString(10);
                    String[] split = city.split(",");
                    String province = split[0];
                    String c = split[1];*/
                    ClueData clueData = new ClueData();
                    clueData.setId(id);
                    clueData.setName(name);
                    clueData.setPhoneNo(phone_no);
                    clueData.setActiviityNo(activity_phone);
                    clueData.setLinkManPhone(linkman_phone);
                    clueData.setWeixin(weixin);
                    clueData.setQq(qq);
                    clueData.setSex(sex);
                    clueData.setJunId(junjun_uid);
                   /* clueData.setProvince(province);
                    clueData.setCity(c);*/
                    res.add(clueData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 批量保存db
     * @param datas
     */
    private void saveBatch(Connection conn, List<ClueData> datas) throws SQLException {
//            String sql = "insert into toclue value (?,?,?,?,?,?,?,?,?,?,?) ";
        StringBuffer sql = new StringBuffer("insert into toclue value");
//        PreparedStatement pstmt = conn.prepareStatement(sql);
        System.out.println("插入数据...............");
        for(int i = 0; i< datas.size();i++){
            ClueData clueData = datas.get(i);
            sql.append("(").append(clueData.getId())
                    .append("'").append(clueData.getName()).append("'")
                    .append("'").append(clueData.getPhoneNo()).append("'")
                    .append("'").append(clueData.getActiviityNo()).append("'")
                    .append("'").append(clueData.getLinkManPhone()).append("'")
                    .append("'").append(clueData.getWeixin()).append("'")
                    .append("'").append(clueData.getQq()).append("'")
                    .append(clueData.getSex())
                    .append(clueData.getJunId())
                    .append("'").append(clueData.getProvince()).append("'")
                    .append("'").append(clueData.getCity()).append("'")
                    .append(")");
            if(i== 30000 || i == datas.size() -1){
                conn.createStatement().execute(sql.toString());
                sql = new StringBuffer("insert into toclue value");
            }
            sql.append(",");
        }
        conn.createStatement().execute(sql.toString());

    }


    class ClueData{
        private Integer id;
        private String name;
        private String phoneNo;
        private String activiityNo;
        private String linkManPhone;
        private String weixin;
        private String qq;
        private Integer sex;
        private Integer junId;
        private String province;
        private String city;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getActiviityNo() {
            return activiityNo;
        }

        public void setActiviityNo(String activiityNo) {
            this.activiityNo = activiityNo;
        }

        public String getLinkManPhone() {
            return linkManPhone;
        }

        public void setLinkManPhone(String linkManPhone) {
            this.linkManPhone = linkManPhone;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public Integer getJunId() {
            return junId;
        }

        public void setJunId(Integer junId) {
            this.junId = junId;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
