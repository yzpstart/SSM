package cn.y.test;

import java.sql.*;

/**
 * @author yu201
 */
public class Test {

    @org.junit.Test
    public void fun1() throws SQLException {
        //1注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:5726/ssm","root","");
        //3获取预处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        //4执行sql，得到结果集
        ResultSet rs = pstm.executeQuery();
        //遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        rs.close();
        pstm.close();
        connection.close();
    }

}
