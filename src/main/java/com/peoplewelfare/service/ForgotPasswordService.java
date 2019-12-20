package com.peoplewelfare.service;


import com.peoplewelfare.model.ForgotUser;

public interface ForgotPasswordService {

    boolean validateUser(ForgotUser login);

    void updatePassword(ForgotUser login);
}
