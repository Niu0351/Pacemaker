package test;

import org.junit.jupiter.api.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

class UserServiceTest {

    @Test
    void registerUser() {
        UserService userService = new UserServiceImpl();
        userService.registerUser(new User(null,"qhr","qhr"));
    }

    @Test
    void login() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.login(new User(null,"qhr","qhr")));
    }

    @Test
    void existUser() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.existUser("qhr"));
    }

    @Test
    void maximumReached(){
        UserService userService = new UserServiceImpl();
        System.out.println(userService.maximumReached());
    }
}