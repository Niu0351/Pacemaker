package dao.impl;

import dao.UserDao;
import pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password from p_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into p_user (username,password) values(?,?)";
        return update(sql, user.getUsername(),user.getPassword());
    }

    @Override
    public User queryByUsernameAndPwd(String username, String password) {
        String sql = "select id,username,password from p_user where username=? and password=?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public Integer queryTotalUser() {
        String sql = "select count(*) from p_user";
        Number count = (Number)queryForSingleValue(sql);
        return count.intValue();
    }

}
