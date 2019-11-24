package com.peoplewelfare.dao.daoImpl;

import com.peoplewelfare.dao.LoginDao;
import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public PersonDetail validateUser(Login validateLogin) {

        LOGGER.info(" =====  INSIDE LoginDaoImpl " + validateLogin.getPersonId() + " " + validateLogin.getPersonPassword());

        Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.personId =:personId  and p.password=:personPassword");
        query.setParameter("personId", validateLogin.getPersonId());
        query.setParameter("personPassword", validateLogin.getPersonPassword());

        if(query.list().size() >0){
        PersonDetail personDetail= (PersonDetail) query.getSingleResult();

        LOGGER.info(personDetail.getPersonId());
        LOGGER.info(personDetail.getPersonFirstName());
        LOGGER.info(personDetail.getPersonLastName());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getGender());
        LOGGER.info(personDetail.getContactNumber());
        LOGGER.info(personDetail.getEmailAddress());
        LOGGER.info(personDetail.getState());
        LOGGER.info(personDetail.getCountry());
        LOGGER.info(personDetail.getNomineeRelation());
        LOGGER.info(personDetail.getPassword());
        LOGGER.info(personDetail.getParentReference());
        LOGGER.info(personDetail.getPersonAddress());



            LOGGER.info("======================2====================");
            return  personDetail;

        }
        else{

            LOGGER.info("======================3====================");
            return null;
        }
    }
}
