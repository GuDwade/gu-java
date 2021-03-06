package gu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import gu.dao.UserDAO;
import gu.model.Response;
import gu.model.User;
import gu.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/login")
@WebServlet("/user/login")
public class LoginServlet  extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user=JSONUtil.read(req.getInputStream(),User.class);
        User queryUser=UserDAO.query(user);
        if(queryUser==null){
            throw new RuntimeException("用户密码校验错误");
        }
        HttpSession session=req.getSession();
        session.setAttribute("user",queryUser);
        return null;
    }
}
