package pers.gg.yh.manager.common.exception;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.gg.yh.manager.common.response.Result;

@ControllerAdvice
public class ServiceExceptionHandler {
    private static final int DEFAULT_EXCEPTION = 500;

    private static final int TOKEN_ERROR_EXCEPTION = 505;
    private static final int TOKEN_EXPIRED_EXCEPTION = 506;

    /**
     * Handle RuntimeException
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public Result<String> runtimeException(RuntimeException e) {
        e.printStackTrace();
        return new Result<>(DEFAULT_EXCEPTION, e.getMessage());
    }

    /**
     * Handle all exception
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Result<String> allException(Exception e) {
        e.printStackTrace();
        return new Result<>(DEFAULT_EXCEPTION, e.getMessage());
    }

    /**
     * Handle token error exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler({SignatureVerificationException.class, AlgorithmMismatchException.class, JWTDecodeException.class})
    public Result<String> tokenErrorException() {
        return new Result<>(TOKEN_ERROR_EXCEPTION, "Invalid token!");
    }

    /**
     * Handle token time out exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler({TokenExpiredException.class})
    public Result<String> tokenExpiredException() {
        return new Result<>(TOKEN_EXPIRED_EXCEPTION, "Token timeout!");
    }
}
