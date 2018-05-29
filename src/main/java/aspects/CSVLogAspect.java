package aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;

/**
 * Created by N.Babenkov on 22.05.2018.
 **/
@Aspect
@Component
public class CSVLogAspect {
    private Logger logger = LoggerFactory.getLogger("pretenzLogger");

    @AfterThrowing(pointcut = "execution(* Utils.CSVManager.getCSVFile())", throwing = "ex")
    public void csvNotFound(ServletException ex) {
        logger.error(ex.getMessage());
    }

    public static void main(String[] args) {

    }
}


