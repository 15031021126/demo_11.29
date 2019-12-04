package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        //构造语句对象
        Statement st=conn.createStatement();
        //创建表、增、改、改记录的SQL语句
        String sql1="create table student(id int primary key auto_increment,name varchar(20) not null,age int not null)";
        String sql2="INSERT INTO student VALUES (2,'李四',28)";
        String sql3="delete from student where id=1";
        String sql4="update student set name=’abc’ where id=2";
        //执行创建表、增、删、改记录
        st.executeUpdate(sql2); //sql1,sql2,sql3,sql4....

        //SQL语句
        String sql="select * from student";
        //执行SQL语句
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            int age=rs.getInt(3);
            System.out.println(id+"--"+name+"--"+age);
        }

        //关闭ResultSet对象
        rs.close();
        //关闭语句对象
        st.close();
        //关闭数据库连接对象
        conn.close();
    }


}
