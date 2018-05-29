package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static Utils.ConfigManager.GetProperty;

/**
 * Created by N.Babenkov on 16.05.2018.
 **/
@Controller
public class UpdateStatusController {
    @RequestMapping(value = "/getStatus", method = RequestMethod.GET)
    public void getStatus(HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String propertyValue = GetProperty("lastUpdate");
        out.write("{\"property\": \"" + propertyValue + "\"}");
        out.flush();
    }
}
