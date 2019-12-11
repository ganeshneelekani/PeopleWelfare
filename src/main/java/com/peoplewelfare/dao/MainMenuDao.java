package com.peoplewelfare.dao;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface MainMenuDao {

    public List<PersonDetail> fetchMemberTreeInfo(String personId);

    public PersonDetail fetchPersonInfo(String personId);

    public List<PersonDetail> fetchDirectList(String personId);

}
