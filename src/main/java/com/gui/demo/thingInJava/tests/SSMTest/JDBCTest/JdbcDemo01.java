package com.gui.demo.thingInJava.tests.SSMTest.JDBCTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.gui.demo.thingInJava.RTTI.Cat;
import com.gui.demo.utils.DruidUtils;
import com.gui.demo.utils.JdbcUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @Classname JdbcDemo01
 * @Description 数据库连接池的使用
 * @Date 2021/7/3 20:46
 * @Created by gt136
 */
public class JdbcDemo01 {
    @Test
    public void jdbc01() throws ClassNotFoundException, SQLException {
        //1.导入驱动jar包 mysql-connector-java
        //2.注册驱动：将此类的字节码文件加载入内存，使得获得此类的全部映射；这个类在导入jar包后就可以省略,因为jar包中已经将该配置写入
        //这个Driver类有一个静态代码块，当加载这个类时就获得了这个类的注册
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*
          3.获取数据库连接对象
           DriverManager:驱动管理对象：注册驱动并获取数据库连接
           getConnection：获取连接
           Connection：这个类包含了获取执行sql的对象方法以及管理事物的方法。包括：createStatement；setAutoCommit；commit；rollback

         */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcnew?serverTimezone=UTC",
                "root", "root");
        //4.定义sql
        //5.获取执行sql的对象，statement：执行静态sql并返回其结果
        /*
         *statement 容易造成sql注入的问题：就是在拼接sql 时，使用计算机逻辑bug，造成安全问题。
         *所以使用 PreparedStatement来执行sql，它使用预编译sql(就是我们现在常用的sql语句)，使用 ? 作为占位符
         * 如：select * from user where username = ? and password = ? ;
         *
         */
        Statement state = conn.createStatement();
        /*
         * 6.执行sql：有三种常用方法：
         *      execute：可以执行任意sql
         *      ResultSet executeQuery()：执行DDL（select）语句。返回ResultSet
         *      int executeUpdate()：执行DMLsql（insert、update、delete）DDL（对表和库的操作语句）
         * ResultSet：结果集：游标默认在0，遍历需要先向下移动一行，且它获取到的是行元素，但是你取数据可以一列一列取
         */
        ResultSet result = state.executeQuery("select cno from course ");
        //7.处理结果
        int i = 0;
        while (result.next()) {
            System.out.println(result.getObject(1));
        }
        //8.释放资源：经常关闭服务器的时候和你说XXX可能内存泄漏是因为某些资源没有被释放
        state.close();
        conn.close();
    }
    /*
    output:
    3-245
    3-105
    9-888
    6-166
     */

    @Test
    public void JdbcTest02() {
//        "com.mysql.cj.jdbc.Driver".getClass();
        Connection connection = null;
        Statement statement = null;

        try {
            //connection = DriverManager.getConnection("jdbc:mysql:///jdbcnew?serverTimezone=UTC", "root", "root");
            connection = JdbcUtils.getConnection("jdbcnew?serverTimezone=UTC");
//            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            int i = statement.executeUpdate(
                    "delete from pet where name = '2-111'");
            if (i > 0) {
                System.out.println(i +" 条"+"执行成功！");
            }else System.out.println("执行失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(statement,connection);
        }
    }

    @Test
    public void jdbcPreparedStatement() {
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection("jdbcnew?serverTimezone=UTC");
            /*
             * Statement 容易造成sql注入的问题：就是在拼接sql 时，使用计算机逻辑bug，造成安全问题。
             * 所以使用 PreparedStatement来执行sql，它使用预编译sql(就是我们现在常用的sql语句)，使用 ? 作为占位符.更安全高效
             * 如：select * from user where username = ? and password = ? ;
             * @author gt
             * @date 2021/7/6 0:05
             */
            pstate = conn.prepareStatement("select name from classes where id = ? ");
            pstate.setInt(1, 3);
            rs = pstate.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs, pstate, conn);
        }
    }

    @Test
    public void jdbcAutoCommit() {
        Connection conn = null;
        PreparedStatement ppst1 = null,
                            ppst2 = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection("jdbcnew?serverTimezone=UTC");
            //开启事务
            conn.setAutoCommit(false);

            ppst1 = conn.prepareStatement("update score set degree = ? where cno = ? ");
            ppst1.setInt(1, 96);
            ppst1.setString(2,"3-105");

            ppst2 = conn.prepareStatement("update score set degree = ? where cno = ? ");
            ppst2.setInt(1, 85);
            ppst2.setString(2,"6-166");

            ppst1.executeUpdate();
//            int i = 3/0;
            ppst2.executeUpdate();


            //
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ppst1, conn);
            JdbcUtils.close(ppst2, null);
        }
    }


    //========================================================================================================
    /*
     * 数据库连接池:节约资源，用户访问高效
     * 实现：
     *      标准接口：DataSource  javax.sql包下
     *      获取连接：getConnection()
     *      归还连接：如果连接对象Connection 是从连接池中获取的，那么Connection.close()，不会关闭，而是归还连接
     *
     * 一般我们不去实现它，由数据库产商实现（mysql，Oracle）：国产Druid（阿里）
     *  Druid：数据库连接池实现技术
     *      步骤：1.导入jar包；2.定义配置文件：properties文件，也得放到resource目录下。 3.获取数据库连接池对象：通过工厂类获取：DruidDataSourceFactory
     *              4.获取连接
     *  为了方便使用，还是定义一个工具类
     */
    @Test
    public void DruidDemo1() {
        //1.导包
        //2、定义配置文件
        //3.加载配置文件

        Properties prop = null;
        try {
            prop = new Properties();
            InputStream stream = getClass().getClassLoader().getResourceAsStream("db.properties");
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //3.获取连接池对象
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void druidTest02() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("select sname from student where sno = ?");
            preparedStatement.setString(1, "103");
//            int i = 3/0;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getObject(1));
            }

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException q) {
                q.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DruidUtils.close(resultSet, preparedStatement, connection);
        }
    }

    //=========================================================================================================
    /*
     *Spring JDBC:Spring 在Jdbc建立的存取框架。作为SpringJdbc框架的核心，Jdbc模板设计的目的是为不同类型的Jdbc操作提供模板方法。
     * 总结：JdbcTemplate是Spring框架自带的对JDBC操作的封装，目的是提供统一的模板方法使对数据库的操作更加方便、友好，效率也不错。
     *      但是功能还是不够强大（比如不支持级联属性），在实际应用中还需要和hibernate、mybaties等框架混合使用。
     * 每个模板都能控制整个过程
     * JdbcTemplate 主要提供一下五类方法：
     *      ·execute方法：可以用于执行任何sql语句，一般用于执行DDL语句
     *      ·query或queryForMap或queryForXXX方法：用于执行查询相关语句并将结果进行封装
     *          ·queryForMap：查询结果将结果集封装为map集合，但是只能封装一条。也就是说只能封装一个map
     *          ·queryForList：查询结果并将结果封装为list集合，它将每一条数据封装为map，最后封装到List中
     *          ·query(sql,new BeanPropertyRowMapper<K>(K.class))：查询并将结果封装为Javabean对象，原生的，没有封装过。
     *          ·queryForObject：查询结果并封装为对象。通常用来查询聚合函数：count(id)
     *      ·update方法：执行DML语句：增删改
     *      ·call方法：用于执行存储过程、函数相关语句。
     */
    @Test
    public void jdbcTemplateTest01() {
        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDs());
        int i = jdbcTemplate.update("update score set degree = ? where cno = ?", 33,"3-245");
        System.out.println(i);
    }

    @Test
    public void jdbcTemplateQueryForList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDs());
        String sql = "insert into student(sno,sname,sgender,sbirthday,class) values(?,?,?,?,?) ";
        int update = jdbcTemplate.update(sql, "111", "施加", "女", "2021-7-10", "95033");
        System.out.println(update);
    }

    @Test
    public void jdbcTemplateQueryForList2() {
        String sql = "select * from student";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDs());
        List<Cat> query = jdbcTemplate.query(sql, (resultSet, i) -> null);
        System.out.println(query);
        System.out.println("=======================");

        List<Student> query1 = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        query1.forEach(System.out::println);
    }

    @Test
    public void jdbcQueryForObject() {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDs());
        Long aLong = template.queryForObject("select count(sno) from student", Long.class);
        System.out.println(aLong);
    }
}

