package com.shenming.pandora.util.filter;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.constant.ErrorContants;
import com.shenming.pandora.model.ResponseEntity;
import com.shenming.pandora.util.ResponseErrorUtil;
import com.shenming.pandora.util.exception.ClientException;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
@WebFilter(urlPatterns = "/*")
public class AccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getRequestURI().toLowerCase().contains("/swagger-ui") || req.getRequestURI().toLowerCase().contains("/api-docs")
                || req.getRequestURI().toLowerCase().contains("/imgbed/config") || req.getRequestURI().toLowerCase().contains("/imgbed/setting")) {
            chain.doFilter(request, response);
        } else {
            String token = req.getHeader("AccessToken");
            try {
                if (token == null || !token.equals("shenming")) {
                    throw new ClientException(ErrorContants.ACCESSTOKEN_INVALID, "token过期", null);
                }
            } catch (ClientException e) {
                ResponseEntity entity = ResponseErrorUtil.convertException(e);
                res.setCharacterEncoding("UTF-8");
                res.getWriter().println(JSON.toJSONString(entity));
                res.getWriter().close();
                return ;
            } catch (Exception e) {
                ResponseEntity entity = ResponseErrorUtil.convertException(e);
                res.setCharacterEncoding("UTF-8");
                res.getWriter().println(JSON.toJSONString(entity));
                res.getWriter().close();
                return ;
            }

            chain.doFilter(req, res);
        }


    }

}
