package com.peoplewelfare.service;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface RegistrationService {

    public List<PersonDetail> validateParentReference();

    public PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception;

    public PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception;
}
