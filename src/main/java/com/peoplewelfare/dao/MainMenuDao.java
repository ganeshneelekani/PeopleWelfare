package com.peoplewelfare.dao;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface MainMenuDao {

    List<PersonDetail> fetchMemberTreeInfo(String personId);

    PersonDetail fetchPersonInfo(String personId);

    List<PersonDetail> fetchDirectList(String personId);

}
