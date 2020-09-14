package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {


    @Test
    public void testLogin(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("1234");
        User login = userDao.login(user);
        System.out.println(login);
    }

    @Test
    public void testReg(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("huihj");
        user.setPassword("1234");
        int count = userDao.register(user);
        System.out.println(count);
    }
}
