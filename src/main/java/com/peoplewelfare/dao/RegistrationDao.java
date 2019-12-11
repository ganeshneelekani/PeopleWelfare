package com.peoplewelfare.dao;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface RegistrationDao {

    public List<PersonDetail> validateParentReference();

    public PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception;

    public PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception;

    public int updatePersonPassword(PersonDetail personDetail) throws Exception;
}
