package com.reem.cloudServlet.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain next) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}