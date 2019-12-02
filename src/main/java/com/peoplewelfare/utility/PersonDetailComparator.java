package com.peoplewelfare.utility;

import com.peoplewelfare.model.PersonDetail;

import java.util.Comparator;

public class PersonDetailComparator implements Comparator<PersonDetail> {

    @Override
    public int compare(PersonDetail t1, PersonDetail t2) {

        int name = t1.getParentReference().compareTo(t2.getParentReference());
        return name;
    }
}
