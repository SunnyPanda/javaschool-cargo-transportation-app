package com.katekozlova.cargo.web.application;

import com.katekozlova.cargo.data.entity.Driver;
import com.katekozlova.cargo.security.AppUserPrincipal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        final AppUserPrincipal principal = (AppUserPrincipal) ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).getPrincipal();
        if (request.isUserInRole("DRIVER")) {
            final Driver driver = principal.getDriver();
            return "redirect:drivers/info/" + driver.getId();
        } else {
            return "index";
        }
    }
}
