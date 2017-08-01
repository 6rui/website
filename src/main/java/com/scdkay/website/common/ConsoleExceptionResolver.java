package com.scdkay.website.common;

import com.scdkay.website.constant.HttpStatus;
import com.scdkay.website.utils.DateUtil;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

/**
 * 异常信息统一处理的类，打印到控制台
 * Created by liurui on 2017/7/13.
 */
public class ConsoleExceptionResolver implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        LOGGER.error("请求的url[" + requestURL + "]发生异常!", e);
        httpServletResponse.setContentType("text/plain; charset=utf-8");
        try {
            PrintWriter out = httpServletResponse.getWriter();
            if (e instanceof TimeoutException) {
                out.println("{\"response_code\":" + HttpStatus.TIMEOUT.getCode() + ",\"response_time\":\""
                        + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss")
                        + "\",\"response_result\":{\"" + HttpStatus.TIMEOUT.getMessage() + "\"}}");
            } else if (e instanceof ConnectException) {
                out.println("{\"response_code\":" + HttpStatus.REFUSE.getCode() + ",\"response_time\":\""
                        + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss")
                        + "\",\"response_result\":{\"" + HttpStatus.REFUSE.getMessage() + "\"}}");
            } else if (e instanceof QueryException) {
                out.println("{\"response_code\":" + HttpStatus.DBERROR.getCode() + ",\"response_time\":\""
                        + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss")
                        + "\",\"response_result\":{\"" + HttpStatus.DBERROR.getMessage() + "\"}}");
            } else {
                out.println("{\"response_code\":" + HttpStatus.ERROR.getCode() + ",\"response_time\":\""
                        + DateUtil.currentDate("yyyy-MM-dd HH:mm:ss")
                        + "\",\"response_result\":{\"" + HttpStatus.ERROR.getMessage() + "\"}}");
            }
        } catch (IOException e1) {
            LOGGER.error("返回输出异常！", e1);
        }
        return null;
    }
}
