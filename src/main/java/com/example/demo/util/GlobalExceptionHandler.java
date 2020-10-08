package com.example.demo.util;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ControllerAdvice和@ExceptionHandler注解来定义全局异常捕获机制。首先创建一个GlobalExceptionHandler类，
 * 然后在该类上加@ControllerAdvice注解，表明这是一个全局异常处理类。
 * 使用@ExceptionHandler(Exception.class)指定捕获的异常类型，这里捕获的是所有的异常，是一个兜底的异常处理
 */


@ControllerAdvice
public class GlobalExceptionHandler {
      private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = CommonErrorException.class)
    @ResponseBody
    public  ResultBody bizExceptionHandler(HttpServletRequest req, CommonErrorException e){
        logger.error("发生业务异常！原因是:",e.getErrorMessage());
        return ResultBody.error(e.getErrorCode(),e.getErrorMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}

