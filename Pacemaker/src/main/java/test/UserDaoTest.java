package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;
import pojo.User;

class UserDaoTest {

    @Test
    void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("qhr"));
    }

    @Test
    void saveUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.saveUser(new User(1,"admin","admin"));
    }

    @Test
    void queryByUsernameAndPwd() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryByUsernameAndPwd("admin","admin"));
    }

    @Test
    void queryTotalUser(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryTotalUser());
    }

}