package com.peoplewelfare.service;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface MainMenuService {

    public List<PersonDetail> fetchMemberTreeInfo(String personId);

    public PersonDetail fetchPersonInfo(String personId);
}
