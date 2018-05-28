package com.katekozlova.cargo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/errors")
public class ErrorController {

    @GetMapping(value = "/404")
    public String notFound() {
        return "errors/404";
    }

    @GetMapping(value = "/400")
    public String badRequest() {
        return "errors/400";
    }

    @GetMapping(value = "/403")
    public String forbidden() {
        return "errors/403";
    }

    @GetMapping(value = "/500")
    public String serverError() {
        return "errors/500";
    }
}



