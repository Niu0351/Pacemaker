package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


public class JdbcUtils {

    private static DruidDataSource dataSource;
    static{
        try {
            Properties properties = new Properties();
            //read in jdbc.properties
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //load data from stream
            properties.load(inputStream);
            //create database connection pool
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * get connection from connection pool
     *
     * */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @param conn
     * close connection
     * */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
