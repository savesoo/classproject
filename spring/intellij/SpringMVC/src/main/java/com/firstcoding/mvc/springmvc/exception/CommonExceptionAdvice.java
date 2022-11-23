package com.firstcoding.mvc.springmvc.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Log4j2
@ControllerAdvice
// 에러를 화면으로 보고자 함
public class CommonExceptionAdvice {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String execptionNumber(NumberFormatException exception){

        log.info(exception.getMessage());

        return "NumberFormatException ... ";
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String execptionNull(NullPointerException exception){

        log.info(exception.getMessage());

        return "NullPointerException ... ";
    }

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String execption(Exception exception){

        log.info(exception.getMessage());

        // 오류 발생시 메시지 출력해서 확인하기
        StackTraceElement[] stackTraceElements = exception.getStackTrace();

        StringBuffer buffer = new StringBuffer("<h1>");
        buffer.append(exception.getMessage() + "</h1>"); // 추가
        buffer.append("<hr>");

        for (StackTraceElement element : stackTraceElements){
            buffer.append("<div>" + element + "</div>");
        }

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){

        return "custom404"; // 특정 view 페이지 만들어줌
    }

}
