package com.peoplewelfare.service.serviceImpl;

import com.peoplewelfare.dao.MainMenuDao;
import com.peoplewelfare.model.PersonDetail;
import com.peoplewelfare.service.MainMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainMenuServiceImpl implements MainMenuService {

    @Autowired
    MainMenuDao mainMenuDao;

    @Override
    public List<PersonDetail> fetchMemberTreeInfo(String personId) {

        List<PersonDetail> personDetails = mainMenuDao.fetchMemberTreeInfo(personId);
        return personDetails;
    }

    @Override
    public PersonDetail fetchPersonInfo(String personId) {
        return mainMenuDao.fetchPersonInfo(personId);
    }

    @Override
    public List<PersonDetail> fetchDirectParentList(String personId) {
        return mainMenuDao.fetchDirectParentList(personId);
    }
}
