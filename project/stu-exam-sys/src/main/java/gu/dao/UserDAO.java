package gu.dao;

import gu.model.*;
import gu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO {
    public static List<User> query() {
        List<User>users=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            c=DBUtil.getConnection();
            String sql ="select u.username,u.nickname,u.password,u.email,u.create_time from user u " ;
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
               User u=new User();
               u.setUsername(rs.getString("username"));
               u.setPassword(rs.getString("password"));
               u.setNickname(rs.getString("nickname"));
               u.setEmail(rs.getString("email"));
               u.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
               users.add(u);
            }
        } catch (SQLException e) {
            throw  new RuntimeException("用户列表出错",e);
        }

        return  users;
    }
    public static User query(User user) {
        User queryUser=null;
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            c=DBUtil.getConnection();
            String sql ="select id,nickname from  user where username=? and password=? " ;
            ps=c.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            while (rs.next()){
                queryUser=user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
            }
        } catch (SQLException e) {
            throw  new RuntimeException("用户登录出错",e);
        }

        return  queryUser;

    }
}
