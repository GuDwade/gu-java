package gu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;

        String uri=req.getServletPath();
        if(!uri.startsWith("/public/")&&!uri.startsWith("/static")&&!"/user/login".equals(uri)){
            HttpSession session= req.getSession(false);
            if(session==null){
                String schema = req.getScheme();//http
                String host = req.getServerName();//服务器ip或域名
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + contextPath;
                res.sendRedirect(basePath + "/public/index.html");
                return;
            }
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
