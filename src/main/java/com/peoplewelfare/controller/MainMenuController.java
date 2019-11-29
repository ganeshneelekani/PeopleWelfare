package com.peoplewelfare.controller;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.MainMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainMenuController {

    static Logger LOGGER = Logger.getLogger(MainMenuController.class);

    @Autowired
    MainMenuService mainMenuService;

    @RequestMapping(value = "/MemberTree/{id}", method = RequestMethod.GET)
    public ModelAndView validateLogin(@PathVariable("id") String personId,HttpServletRequest request,
                              HttpServletResponse response,
                              @ModelAttribute("login") Login user) {



        LOGGER.info("===========================1 Member Tree======================="+personId);


        List<PersonDetail> detailList=mainMenuService.fetchMemberTreeInfo(personId);
        for (PersonDetail personDetail : detailList) {

            LOGGER.info("=======5.3=====" + personDetail.getPersonId() +"   "+personDetail.getParentReference());

        }

        ModelAndView mav = new ModelAndView("teamMember");
        return mav;
    }
}
