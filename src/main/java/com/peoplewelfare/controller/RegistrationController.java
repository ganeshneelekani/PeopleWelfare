package com.peoplewelfare.controller;

import com.peoplewelfare.model.ForgotUser;
import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.ForgotPasswordService;
import com.peoplewelfare.service.RegistrationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gn033604 on 9/7/17.
 */
@Controller
public class RegistrationController {

    static Logger LOGGER = Logger.getLogger(RegistrationController.class);

    @Autowired
    RegistrationService registrationService;

    @Autowired
    ForgotPasswordService forgotPasswordService;

    @RequestMapping(value = "/RegisterPerson", method = RequestMethod.GET)
    public ModelAndView getRegistrationModel(HttpServletRequest request, HttpServletResponse response) {


        LOGGER.info("===================4===============");
        ModelAndView mav = new ModelAndView("personRegistration");
        mav.addObject("personRegistration", new PersonDetail());

        return mav;
    }


    @RequestMapping(value = "/RegisterPersonDetails", method = RequestMethod.POST)
    public ModelAndView postRegistrationPersonDetails(HttpServletRequest request, HttpServletResponse response,
                                                      @ModelAttribute("personRegistration") PersonDetail personDetail) {
        ModelAndView model = new ModelAndView("personRegistration");
        try {


            LOGGER.info("===================5===============");
            List<PersonDetail> listOfPersonDetail = registrationService.validateParentReference();
            List<String> listOfPersonId = new LinkedList<>();
            List<String> listOfParentReference = new LinkedList<>();

            listOfPersonDetail.forEach(person -> {
                listOfPersonId.add(person.getPersonId().toUpperCase());
                listOfParentReference.add(person.getParentReference().toUpperCase());

            });

            int frequency = Collections.frequency(listOfParentReference, personDetail.getParentReference());
            boolean validReference = listOfPersonId.contains(personDetail.getParentReference().trim().toUpperCase());

            LOGGER.info("======2=====" + frequency +
                    "===================5.1===============" + validReference);


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

            if (frequency >= 3) {
                model.addObject("msg", " Reference " + personDetail.getParentReference() + " has 3 child member already");
                model.addObject("personRegistration", personDetail);
                return model;

            } else if (frequency < 4 && validReference) {
                PersonDetail details = registrationService.savePersonDetail(personDetail);
                LOGGER.info("==================3=========" + details.getPersonId());

                ModelAndView loginModel = new ModelAndView("login");
                loginModel.addObject("login", new Login());
                loginModel.addObject("loginCredential", " Person ID " + personDetail.getPersonId() + " is registered." +
                        " " +
                        "Please " +
                        "login to continue");
                return loginModel;

            } else {

                LOGGER.info("=======================5.2========================");

                model.addObject("msg", " Reference " + personDetail.getParentReference() + " is registered");
                model.addObject("personRegistration", personDetail);
                return model;
            }


        } catch (Exception e) {
            model.addObject("exceptionMsg", "Some thing went wrong please try registering again");
            model.addObject("personRegistration", new PersonDetail());
            return model;
        }
    }

    @RequestMapping(value = "/ForgotPassword", method = RequestMethod.GET)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("================2===================");
        ModelAndView mav = new ModelAndView("forgotPassword");
        mav.addObject("forgotpassword", new ForgotUser());
        return mav;
    }


    @RequestMapping(value = "/UpdateForgotPassword", method = RequestMethod.POST)
    public Object validateLogin(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("forgotpassword") ForgotUser forgotUser) {


        LOGGER.info(forgotUser.getPersonId() + "===============3===================" + forgotUser.getPassword());

        boolean value = forgotPasswordService.validateUser(forgotUser);

        LOGGER.info(value + " OOOOOOO");

        if (value == true) {

            ModelAndView model = new ModelAndView("login");
            model.addObject("msg", " Password changed successfully Login to continue");
            model.addObject("login", new Login());
            return model;
        } else {

            ModelAndView model = new ModelAndView("forgotPassword");
            model.addObject("msg", " PersonId and contact number does not match ");
            model.addObject("forgotpassword", new ForgotUser());
            return model;
        }

    }
}