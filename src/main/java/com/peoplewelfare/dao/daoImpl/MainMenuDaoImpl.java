package com.peoplewelfare.dao.daoImpl;

import com.peoplewelfare.dao.MainMenuDao;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MainMenuDaoImpl implements MainMenuDao {

    static Logger LOGGER = Logger.getLogger(MainMenuDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private List<PersonDetail> personDetailsChild;
    private List<PersonDetail> listPersonDetails;
    private List<PersonDetail> listChildPersonDetails;

    @Override
    public List<PersonDetail> fetchMemberTreeInfo(String personId) {


        personDetailsChild = new ArrayList<>();
        listPersonDetails = new ArrayList<>();
        listChildPersonDetails = new ArrayList<>();

        Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.personId =:personId");
        query.setParameter("personId", personId);

        List<PersonDetail> personDetails = query.list();

        LOGGER.info("===================ppppppppppppppppppp============" + personDetails.size());

        for (PersonDetail personDetail :
                personDetails) {

            LOGGER.info("=======2.1=====" + personDetail.getPersonId());
            listPersonDetails = fetchRecursiveChild(personDetail.getPersonId(), 3);

        }

        personDetails.addAll(listPersonDetails);

        for (PersonDetail personDetail : personDetails) {

            LOGGER.info("=======4.3=====" + personDetail.getPersonId());

        }
        return personDetails;
    }

    @Override
    public PersonDetail fetchPersonInfo(String personId) {
        Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.personId =:personId");
        query.setParameter("personId", personId);

        PersonDetail personDetails = (PersonDetail) query.getSingleResult();
        return personDetails;
    }

    @Override
    public List<PersonDetail> fetchDirectList(String personId) {

        Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.parentReference =:parentReference");
        query.setParameter("parentReference", personId);

        List<PersonDetail> personDetails = query.list();
        return personDetails;
    }


    private List<PersonDetail> fetchRecursiveChild(String personId, int n) {

        if (n > 0) {
            LOGGER.info("=======23232323=====");

            Query queryChild = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p" +
                    ".parentReference=:parentReference");
            queryChild.setParameter("parentReference", personId);

            listChildPersonDetails = queryChild.list();

            LOGGER.info(listChildPersonDetails + " PPPPPPPPPPPPPPPPPPP");

            if (listChildPersonDetails.size() > 0) {
                personDetailsChild.addAll(listChildPersonDetails);
            }

            for (PersonDetail personDetail :
                    listChildPersonDetails) {


                if (n > 0) {
                    LOGGER.info("=======2.2=====" + personDetail.getPersonId());
                    fetchRecursiveChild(personDetail.getPersonId(), n - 1);
                }

            }

            LOGGER.info("=======================5======================");

        }
        return personDetailsChild;
    }


}