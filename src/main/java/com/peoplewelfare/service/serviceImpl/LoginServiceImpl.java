package com.peoplewelfare.service.serviceImpl;


import com.peoplewelfare.dao.LoginDao;
import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gn033604 on 9/2/17.
 */
@Service
public class LoginServiceImpl implements LoginService {

    static Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    LoginDao loginDao;

    @Override
    public PersonDetail validateUser(Login login) {

        LOGGER.info(" ========== INSIDE LoginServiceImpl ");
        PersonDetail validatedLogin = loginDao.validateUser(login);
        return validatedLogin;
    }

}