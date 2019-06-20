package com.pengfei.base.filter;

import com.pengfei.base.bean.ReturnResult;
import com.pengfei.base.common.ThreadLocalRequest;
import com.pengfei.base.common.ThreadLocalResponse;
import com.pengfei.base.wrapper.BodyCachingHttpServletRequestWrapper;
import com.pengfei.utils.empty.EmptyUtils;
import com.pengfei.utils.json.JsonUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "PengfeiFilter",urlPatterns = "/*")
public class PengfeiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("*************************************************************************");
        System.out.println();
        System.out.println("                            PengfeiFilter init start                      ");
        System.out.println();
        System.out.println("*************************************************************************");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setCharacterEncoding("utf-8");
        ThreadLocalRequest.set( request );
        ThreadLocalResponse.set(response);
        BodyCachingHttpServletRequestWrapper requestWrapper = new BodyCachingHttpServletRequestWrapper((HttpServletRequest) request);
        byte[] requestBody = requestWrapper.getBody();
        try {
            filterChain.doFilter(requestWrapper, servletResponse);
        } catch (Exception e){
            try {
                e.printStackTrace();
                if( EmptyUtils.isEmpty(e.getCause()) ){
                    response.getWriter().println(JsonUtils.toJson(ReturnResult.Error(e.getMessage())));
                } else {
                    response.getWriter().println(JsonUtils.toJson(ReturnResult.Error(e.getCause().getMessage())));
                }
            } catch (Exception e1){
                e1.printStackTrace();
                response.getWriter().println(e.getMessage());
            }
        } finally {
            ThreadLocalRequest.remove();
            ThreadLocalResponse.remove();
        }
    }

    @Override
    public void destroy() {

    }
}
