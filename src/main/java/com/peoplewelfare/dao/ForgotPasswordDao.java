package com.peoplewelfare.dao;

import com.peoplewelfare.model.ForgotUser;

public interface ForgotPasswordDao {

    boolean validateUser(ForgotUser forgotUser);

    void updatePassword(ForgotUser login);
}
