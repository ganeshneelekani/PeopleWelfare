package com.peoplewelfare.service.serviceImpl;

import com.peoplewelfare.dao.RegistrationDao;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gn033604 on 9/7/17.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationDao registrationDao;

    @Override
    public List<PersonDetail> validateParentReference() {

        return registrationDao.validateParentReference();
    }

    @Override
    public PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception {
        PersonDetail detail = registrationDao.savePersonDetail(personDetail);
        return detail;
    }

    @Override
    public PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception {
        PersonDetail detail = registrationDao.updatePersonDetail(personDetail);
        return detail;
    }

    @Override
    public int updatePersonPassword(PersonDetail personDetail) throws Exception {
        return registrationDao.updatePersonPassword(personDetail);

    }
}
