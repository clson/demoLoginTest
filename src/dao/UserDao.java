package dao;


import domain.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());


    public User login(User loginUser){
        try {
            String sql="select * from user where username=? and password=?";
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int register(User regUser){
        String sql="insert into user(username,password) values (?,?)";
        int count=0;
         if (StringUtils.isNotBlank(regUser.getUsername())&&StringUtils.isNotBlank(regUser.getPassword())){
             count = jdbcTemplate.update(sql, regUser.getUsername(), regUser.getPassword());
         }
         return count;
    }


}
