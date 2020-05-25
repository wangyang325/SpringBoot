package wangyang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GException {
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> hasMap = new HashMap<String, Object>();
        hasMap.put("errorCode", 500);
        hasMap.put("errorMessage", "Error");
        System.out.println("GlobalExceptionHandler is running");
        return hasMap;
    }
}
