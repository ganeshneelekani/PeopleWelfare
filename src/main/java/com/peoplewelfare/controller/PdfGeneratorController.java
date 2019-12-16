package com.peoplewelfare.controller;

import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.MainMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class PdfGeneratorController  {

    @Autowired
    MainMenuService mainMenuService;

    static Logger LOGGER = Logger.getLogger(PdfGeneratorController.class);

    @RequestMapping(value = "/downloadPDF/{id}", method = RequestMethod.GET)
    public ModelAndView validateLogin(@PathVariable("id") String personId
                                   ) {

        List<PersonDetail> personDetailDirectList=mainMenuService.fetchDirectList(personId);


        for (PersonDetail personDetail : personDetailDirectList) {
            LOGGER.info(personDetail.getPersonId());
        }

        LOGGER.info("========PDF=================="+personId);


        return new ModelAndView("pdfView", "PersonDetail", personDetailDirectList);



    }



}
