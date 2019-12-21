package com.peoplewelfare.service;

import com.peoplewelfare.model.PersonDetail;

import java.util.List;

public interface MainMenuService {

    List<PersonDetail> fetchMemberTreeInfo(String personId);

    PersonDetail fetchPersonInfo(String personId);

    List<PersonDetail> fetchDirectParentList(String personId);
}
