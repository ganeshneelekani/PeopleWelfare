package com.peoplewelfare.controller;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    static Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {


        LOGGER.info("================1====================");

        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("================2===================");
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView validateLogin(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login user) {


        LOGGER.info(user.getUsername()+"===============3==================="+user.getPassword());
        Login validatedLogin=loginService.validateUser(user);
        LOGGER.info(validatedLogin.getUsername() +" =======ID====1");
        LOGGER.info(validatedLogin.getPassword()+" ===============PASSWORD===2");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public ModelAndView addUserGetRequest(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("login") Login user) {
        LOGGER.info("================4====================");


        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
}