package com.peoplewelfare.service.serviceImpl;

import com.peoplewelfare.dao.ForgotPasswordDao;
import com.peoplewelfare.model.ForgotUser;
import com.peoplewelfare.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    @Autowired
    ForgotPasswordDao forgotPasswordDao;

    @Override
    public boolean validateUser(ForgotUser forgotUser) {
        return forgotPasswordDao.validateUser(forgotUser);
    }
}
