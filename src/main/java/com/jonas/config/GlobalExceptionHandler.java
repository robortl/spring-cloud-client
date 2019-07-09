package com.jonas.config;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.jonas.constant.BizException;
import com.jonas.constant.JsonResult;
import com.jonas.constant.SystemCode;
import com.jonas.util.logging.SystemLogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/11/01
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception ex) {
        if (ex instanceof BizException) {
            Iterable iterable = Splitter.on(":").trimResults().omitEmptyStrings().split(ex.getMessage());
            List<String> item = Lists.newArrayList(iterable);
            log.info("BizException:{},{}",item.get(1), item.get(2));
            return new JsonResult(item.get(1), item.get(2), null);
        }else if (ex instanceof MissingServletRequestParameterException){
            log.info("MissingServletRequestParameterException:{},{}",
                    SystemCode.PARAM_ERROR.getCode(),ex.getMessage());
            return new JsonResult(SystemCode.PARAM_ERROR.getCode(),ex.getMessage(),null);
        }


        log.error("handle exception:{}",ex);
        return new JsonResult(SystemCode.SERVER_ERROR);
    }
}
