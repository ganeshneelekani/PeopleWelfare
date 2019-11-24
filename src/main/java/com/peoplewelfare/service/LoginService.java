package com.peoplewelfare.service;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;

/**
 * Created by gn033604 on 9/2/17.
 */
public interface LoginService {

    public PersonDetail validateUser(Login login);


}
