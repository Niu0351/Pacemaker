package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {

    //Use DbUtils to manipulate database
    private QueryRunner queryRunner = new QueryRunner();

    /**
     *  update info in terms of sql
     * @param sql
	 * @param args
     * @return
     * @author Haoran Qi
     * @date
     */
    public int update(String sql,Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     *
     * @param type the return object type
	 * @param sql  sql implemented
     * @param args   parameter that passes into sql
     * @return
     * @author Haoran Qi
     * @date
     */
    public <T> T queryForOne(Class<T> type, String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * query for several javaBean SQL
     * @param type the return object type
     * @param sql  sql implemented
     * @param args   parameter that passes into sql
     * @return
     * @author Haoran Qi
     * @date
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * query for single value ex:count
     * @param sql  sql implemented
     * @param args   parameter that passes into sql
     * @return
     * @author Haoran Qi
     * @date
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}
