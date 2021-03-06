package controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by N.Babenkov on 27.04.2018.
 **/
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(value = {ServletException.class, IOException.class, SQLException.class})
    public @ResponseBody
    String servletError(Exception ex){
        //TODO: add proper error handling
        return ex.getMessage();
    }

}
