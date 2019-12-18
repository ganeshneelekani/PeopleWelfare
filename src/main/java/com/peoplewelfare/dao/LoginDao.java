package com.peoplewelfare.dao;


import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;

/**
 * Created by gn033604 on 9/2/17.
 */
public interface LoginDao {

    PersonDetail validateUser(Login login);

}
