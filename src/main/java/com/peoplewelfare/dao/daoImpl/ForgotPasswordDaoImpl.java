package com.peoplewelfare.dao.daoImpl;

import com.peoplewelfare.dao.ForgotPasswordDao;
import com.peoplewelfare.model.ForgotUser;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ForgotPasswordDaoImpl implements ForgotPasswordDao {

    static Logger LOGGER = Logger.getLogger(ForgotPasswordDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean validateUser(ForgotUser forgotUser) {

        Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.personId =:personId  and p.contactNumber=:contactNumber");
        query.setParameter("personId", forgotUser.getPersonId());
        query.setParameter("contactNumber", forgotUser.getContactNumber());

        List<ForgotUser> forgotUsers = query.list();

        LOGGER.info("===================ppppppppppppppppppp============" + forgotUsers.size());

        if (forgotUsers.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(ForgotUser forgotUser) {


        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query queryUpdate = session.createQuery("update PersonDetail set password = :password" +
                " where personId = :personId");
        queryUpdate.setParameter("password", forgotUser.getPassword());
        queryUpdate.setParameter("personId", forgotUser.getPersonId());
        int result = queryUpdate.executeUpdate();
        if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().commit();
        }
        session.close();

    }
}
