package gu.servlet;

import gu.dao.ExamRecordDAO;
import gu.model.ExamRecord;
import gu.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/delete")
public class ExamRecordDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");
        int num=ExamRecordDAO.delete(ids);
        return  null;
    }
}
