package gu.servlet;

import gu.dao.ExamDAO;
import gu.dao.UserDAO;
import gu.model.Exam;
import gu.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/user/query")
public class UserMangementServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<User> users=UserDAO.query();
        return users;
    }
}
