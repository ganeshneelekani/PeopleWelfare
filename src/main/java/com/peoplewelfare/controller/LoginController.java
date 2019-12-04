package com.peoplewelfare.controller;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    static Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    PersonDetail validatedLogin;

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

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView doLogin(HttpServletRequest request, Model model) {

        ModelAndView mav = new ModelAndView("mainMenu");

        model.addAttribute("personDetail", validatedLogin);
        LOGGER.info("====================4=====================1234"+validatedLogin.getPersonFirstName());
        return mav;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public Object validateLogin(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute("login") Login user, RedirectAttributes redirectAttributes) {


        LOGGER.info(user.getPersonId() + "===============3===================" + user.getPersonPassword());
        validatedLogin = loginService.validateUser(user);

        LOGGER.info(validatedLogin + " OOOOOOO");

        if (validatedLogin == null) {

            ModelAndView model = new ModelAndView("login");
            model.addObject("msg", "Person Id and Password is not match");
            model.addObject("login", new Login());
            return model;
        } else {

            LOGGER.info("==================4===================="+validatedLogin.getPersonId());
            return "redirect:/home";
        }

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