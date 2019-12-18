package com.peoplewelfare.controller;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.LoginService;
import com.peoplewelfare.service.MainMenuService;
import com.peoplewelfare.service.RegistrationService;
import com.peoplewelfare.utility.PersonDetailComparator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@Controller
public class LoginController {

    static Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    MainMenuService mainMenuService;

    @Autowired
    RegistrationService registrationService;

    PersonDetail validatedLogin;

    PersonDetail fetchPersonDetailInfo;

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
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView model = new ModelAndView("mainMenu");

        List<PersonDetail> personDetailDirectList = mainMenuService.fetchDirectList(validatedLogin.getPersonId());
        PersonDetail personDetail = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());
        model.addObject("personDetail", personDetail);
        model.addObject("personDetailDirectList", personDetailDirectList);

        for (PersonDetail detail : personDetailDirectList) {
            LOGGER.info(detail.getPersonId() + " :::::::  ");
        }

        LOGGER.info("====================4=====================1234" + validatedLogin.getPersonFirstName());
        return model;
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

            LOGGER.info("==================4====================" + validatedLogin.getPersonId());
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

    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public ModelAndView viewProfile(HttpServletRequest request, HttpServletResponse response
    ) {
        LOGGER.info("================4 viewProfile ====================");
        PersonDetail fetchPersonDetail = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());
        ModelAndView modelView = new ModelAndView("viewProfile");
        modelView.addObject("personDetail", fetchPersonDetail);
        return modelView;
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
    public ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response
    ) {
        LOGGER.info("================4 viewProfile ====================");
        fetchPersonDetailInfo = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());
        ModelAndView modelView = new ModelAndView("profileUpdate");
        modelView.addObject("personRegistration", fetchPersonDetailInfo);
        return modelView;
    }

    @RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
    public ModelAndView UpdateChangePassword(HttpServletRequest request, HttpServletResponse response
    ) {
        LOGGER.info("================4 viewProfile ====================");
        fetchPersonDetailInfo = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());
        ModelAndView modelView = new ModelAndView("updatePassword");
        modelView.addObject("personRegistration", fetchPersonDetailInfo);
        return modelView;
    }

    @RequestMapping(value = "/UpdatePassword", method = RequestMethod.GET)
    public ModelAndView UpdatePasswordGet(HttpServletRequest request, HttpServletResponse response
    ) {
        LOGGER.info("================4545 viewProfile ====================");
        fetchPersonDetailInfo = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());
        ModelAndView modelView = new ModelAndView("updatePassword");
        modelView.addObject("personRegistration", fetchPersonDetailInfo);
        return modelView;
    }

    @RequestMapping(value = "/UpdatePassword", method = RequestMethod.POST)
    public ModelAndView postUpdatePasswordDetails(HttpServletRequest request, HttpServletResponse response,
                                                  @ModelAttribute("personRegistration") PersonDetail personDetail) {
        ModelAndView model = new ModelAndView("updatePassword");


        LOGGER.info(personDetail.getPersonId());
        LOGGER.info(personDetail.getPersonFirstName());
        LOGGER.info(personDetail.getPersonLastName());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getGender());
        LOGGER.info(personDetail.getContactNumber());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getState());
        LOGGER.info(personDetail.getCountry());
        LOGGER.info(personDetail.getNomineeRelation());

        LOGGER.info(personDetail.getParentReference());
        LOGGER.info(personDetail.getPersonAddress());
        LOGGER.info(personDetail.getPinCode());


        LOGGER.info(personDetail.getPassword());
        LOGGER.info(personDetail.getVerifyPassword());

        personDetail.setPersonId(fetchPersonDetailInfo.getPersonId());

        LOGGER.info("=================== update 5 password===============" + personDetail.getPassword());

        if (personDetail.getPassword().isEmpty()) {
            model.addObject("personRegistration", new PersonDetail());
            return model;
        }


        try {

            int result = registrationService.updatePersonPassword(personDetail);

            LOGGER.info("==================3 result =========" + result);

            model.addObject("msg", " Password is updated");
            model.addObject("personRegistration", new PersonDetail());
            return model;


        } catch (Exception e) {
            model.addObject("exceptionMsg", "Some thing went wrong please try registering again");
            model.addObject("personRegistration", new PersonDetail());
            return model;
        }
    }

    @RequestMapping(value = "/updatePersonRegistrationForm", method = RequestMethod.POST)
    public ModelAndView postUpdatePersonDetails(HttpServletRequest request, HttpServletResponse response,
                                                @ModelAttribute("personRegistration") PersonDetail personDetail) {
        ModelAndView model = new ModelAndView("profileUpdate");

        personDetail.setParentReference(fetchPersonDetailInfo.getParentReference());
        personDetail.setPassword(fetchPersonDetailInfo.getPassword());
        personDetail.setVerifyPassword(fetchPersonDetailInfo.getVerifyPassword());
        personDetail.setPersonId(fetchPersonDetailInfo.getPersonId());

        LOGGER.info("=================== update 5===============" + personDetail.getParentReference());


        LOGGER.info(personDetail.getPersonId());
        LOGGER.info(personDetail.getPersonFirstName());
        LOGGER.info(personDetail.getPersonLastName());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getGender());
        LOGGER.info(personDetail.getContactNumber());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getState());
        LOGGER.info(personDetail.getCountry());
        LOGGER.info(personDetail.getNomineeRelation());
        LOGGER.info(personDetail.getPassword());
        LOGGER.info(personDetail.getParentReference());
        LOGGER.info(personDetail.getPersonAddress());
        LOGGER.info(personDetail.getPinCode());

        try {

            PersonDetail details = registrationService.updatePersonDetail(personDetail);
            LOGGER.info("==================3=========" + details.getContactNumber());

            model.addObject("msg", " Reference " + personDetail.getPersonId() + " is updated");
            model.addObject("personRegistration", personDetail);
            return model;


        } catch (Exception e) {
            model.addObject("exceptionMsg", "Some thing went wrong please try registering again");
            model.addObject("personRegistration", new PersonDetail());
            return model;
        }
    }


    @RequestMapping(value = "/MemberTree", method = RequestMethod.GET)
    public ModelAndView getMemberTree(HttpServletRequest request, HttpServletResponse response,
                                      RedirectAttributes redirectAttributes) {

        PersonDetail fetchPersonDetail = mainMenuService.fetchPersonInfo(validatedLogin.getPersonId());

        LOGGER.info("===========================1 Member Tree=======================" + validatedLogin.getPersonId());


        List<PersonDetail> detailList = mainMenuService.fetchMemberTreeInfo(validatedLogin.getPersonId());


        Collections.sort(detailList, new PersonDetailComparator());

        StringBuffer nodes = new StringBuffer();
        for (PersonDetail personDetail : detailList) {

            LOGGER.info("=======5.3=====" + personDetail.getPersonId() + "   " + personDetail.getParentReference());

            nodes.append(" { id: " + "\"" + personDetail.getPersonId() + "\"" + ", pid: " + "\"" + personDetail.getParentReference() +
                    "\" " + ", tags: " +
                    "[\"family_template_11\"], name: " + "\"" + personDetail.getPersonFirstName() + "\"" + ", title: " +
                    "\"" + personDetail.getPersonId() + "\"" + "},").append(
                    "\n");

        }

        LOGGER.info(nodes);


        ModelAndView modelView = new ModelAndView("mainMenuMemberTree");
        modelView.addObject("nodes", nodes);
        modelView.addObject("personDetail", fetchPersonDetail);
        return modelView;
    }
}