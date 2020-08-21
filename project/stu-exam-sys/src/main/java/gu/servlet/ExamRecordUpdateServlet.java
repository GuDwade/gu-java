package gu.servlet;

import gu.dao.ExamRecordDAO;
import gu.model.ExamRecord;
import gu.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/update")
public class ExamRecordUpdateServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ExamRecord record=JSONUtil.read(req.getInputStream(),ExamRecord.class);
        int num=ExamRecordDAO.update(record);
        return  null;
    }
}
