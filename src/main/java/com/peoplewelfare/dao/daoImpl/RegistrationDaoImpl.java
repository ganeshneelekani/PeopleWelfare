package com.peoplewelfare.dao.daoImpl;

import com.peoplewelfare.dao.RegistrationDao;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gn033604 on 9/7/17.
 */
@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

    static Logger LOGGER = Logger.getLogger(RegistrationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PersonDetail> validateParentReference() {

        Query query = sessionFactory.getCurrentSession().createQuery("from PersonDetail");
        return query.list();
    }

    @Override
    public PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception {
        Session session = sessionFactory.openSession();


        Query query = session.createQuery("from PersonDetail order by personId DESC");
        query.setMaxResults(1);
        PersonDetail lastRecord = (PersonDetail) query.uniqueResult();
        int appendedValue = Integer.valueOf(lastRecord.getPersonId().substring(2)) + 1;

        LOGGER.info("============last person ID======" + "PP" + appendedValue);

        session.beginTransaction();
        String personId = "PP" + appendedValue;

        personDetail.setPersonId(personId);

        session.save(personDetail);
        if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().commit();
        }
        session.close();
        return personDetail;
    }

    @Override
    public PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(personDetail);
        if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().commit();
        }
        session.close();
        return personDetail;
    }

    @Override
    public int updatePersonPassword(PersonDetail personDetail) throws Exception {

        LOGGER.info("===============================33333==============="+personDetail.getPassword() + "   "+personDetail.getPersonId());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update PersonDetail set password = :password where personId = :personId");
        query.setParameter("password", personDetail.getPassword());
        query.setParameter("personId", personDetail.getPersonId());

        int result = query.executeUpdate();
        if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().commit();
        }
        session.close();
        return result;

    }
}
