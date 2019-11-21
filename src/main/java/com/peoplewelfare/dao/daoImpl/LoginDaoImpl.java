package com.peoplewelfare.dao.daoImpl;

import com.peoplewelfare.dao.LoginDao;
import com.peoplewelfare.model.Login;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.List;

/**
 * Created by gn033604 on 9/2/17.
 */
@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

    static Logger LOGGER = Logger.getLogger(LoginDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Login validateUser(Login login) {

        LOGGER.info(" =====  INSIDE LoginDaoImpl ");

        Login validatedLogin=new Login();
        Query q = sessionFactory.getCurrentSession().createQuery(" select p.personId,p.password from PersonDetail p");
        List<Object[]> personDetails= (List<Object[]>)q.list();

        LOGGER.info(personDetails.size() +"======");
        for(Object[] personDetail: personDetails){
            String id = (String) personDetail[0];
            String password = (String)personDetail[1];


            validatedLogin.setUsername(id);
            validatedLogin.setPassword(password);
        }

        LOGGER.info(login.getUsername());
        LOGGER.info(login.getPassword());
       return  validatedLogin;
    }


}
