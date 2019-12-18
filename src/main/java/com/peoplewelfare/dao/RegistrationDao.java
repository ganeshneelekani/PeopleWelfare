package com.peoplewelfare.dao;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface RegistrationDao {

    List<PersonDetail> validateParentReference();

    PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception;

    PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception;

    int updatePersonPassword(PersonDetail personDetail) throws Exception;
}
