package com.pop.app.handle;

import com.pop.app.enums.ClientCode;
import com.pop.app.response.ResultResponse;
import com.pop.exception.ExceptionInfo;
import com.pop.exception.ExceptionInfoGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 统一异常解析。 负责拦截所有Rest抛出的异常。
 */
@ControllerAdvice
public class ExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResultResponse handleException(Exception ex) {
        ResultResponse exceptionData = null;
        Throwable exception = getHasInfoException(ex);
        if (exception == null) {
            exceptionData = new ResultResponse();
            exceptionData.setResult(ClientCode.SYSTEM_WRONG.getCode());
            exceptionData.setErrorMsg(ClientCode.SYSTEM_WRONG.getMsg());
        } else {
            ExceptionInfo exceptionInfo = ((ExceptionInfoGetter) exception).getInfo();
            String message  = exceptionInfo.getMessage();;
            Integer code = exceptionInfo.getCode();

            if (StringUtils.isEmpty(message)) {
                message = ClientCode.SYSTEM_WRONG.getMsg();
            }
            exceptionData = new ResultResponse();
            exceptionData.setResult(code);
            exceptionData.setErrorMsg(message);
        }

        logger.error("exception code:" + exceptionData.getResult() + ",exception message:" + exceptionData.getErrorMsg(),
                ex);

        return exceptionData;
    }

    private Throwable getHasInfoException(Throwable throwable) {
        Throwable exception = null;

        if (throwable instanceof ExceptionInfoGetter) {
            exception = (Exception) throwable;
        }

        Throwable childThrowable = null;
        if (throwable instanceof UndeclaredThrowableException) {
            childThrowable = ((UndeclaredThrowableException) throwable).getUndeclaredThrowable();
        } else {
            childThrowable = throwable.getCause();
        }
        if (childThrowable != null) {
            Throwable childExp = getHasInfoException(childThrowable);
            if (childExp != null) {
                return childExp;
            }
        }

        return exception;
    }
}
