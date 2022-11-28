package com.mytodolist.springtodo.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String except(Exception exception){
        log.info(exception.getMessage());

        return exception.getMessage();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "error/404error"; // view 경로 지정 가능
    }

}
