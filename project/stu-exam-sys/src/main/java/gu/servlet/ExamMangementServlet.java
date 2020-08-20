package gu.servlet;

import gu.dao.ExamDAO;
import gu.model.Exam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/exam/query")
public class ExamMangementServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Exam>exams=ExamDAO.queryExams();
        return  exams;
    }
}
