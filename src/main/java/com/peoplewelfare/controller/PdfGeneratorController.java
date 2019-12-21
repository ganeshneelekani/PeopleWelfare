package com.peoplewelfare.controller;

import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.MainMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PdfGeneratorController {

    static Logger LOGGER = Logger.getLogger(PdfGeneratorController.class);
    @Autowired
    MainMenuService mainMenuService;


}
