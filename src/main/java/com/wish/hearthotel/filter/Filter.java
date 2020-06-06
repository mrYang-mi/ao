package com.wish.hearthotel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        //当前请求的url
        String uri = request.getRequestURI();
        System.out.println("filter url:"+uri);
        //判断url是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            chain.doFilter(req, resp);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if (null != session && null != session.getAttribute("username")) {
                chain.doFilter(request, response);
            } else {
response.sendRedirect("login.html");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

        public boolean isNeedFilter(String uri) {
String [] includeUrls=new String[]{};
            for (String includeUrl : includeUrls) {
                if(includeUrl.equals(uri)) {
                    return false;
                }
            }
            return true;
        }

}
