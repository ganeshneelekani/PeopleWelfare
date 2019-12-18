package com.peoplewelfare.service;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface RegistrationService {

    List<PersonDetail> validateParentReference();

    PersonDetail savePersonDetail(PersonDetail personDetail) throws Exception;

    PersonDetail updatePersonDetail(PersonDetail personDetail) throws Exception;

    int updatePersonPassword(PersonDetail personDetail) throws Exception;
}
