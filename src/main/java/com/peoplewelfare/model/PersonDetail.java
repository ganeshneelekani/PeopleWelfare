package com.peoplewelfare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetail {

    @Id
    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "PERSON_FIRSTNAME")
    private String personFirstName;

    @Column(name = "PERSON_LASTNAME")
    private String personLastName;

    @Column(name = "PERSON_GENDER")
    private String gender;

    @Column(name = "PERSON_BDATE")
    private Date personBDate;

    @Column(name = "PERSON_ADDRESS")
    private String personAddress;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PINCODE")
    private String personReferred;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "NOMINEE")
    private String nominee;

    @Column(name = "NOMINEE_RELATION")
    private String nomineeRelation;

    @Column(name = "PERSON_PASSWORD")
    private String password;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getPersonBDate() {
        return personBDate;
    }

    public void setPersonBDate(Date personBDate) {
        this.personBDate = personBDate;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonReferred() {
        return personReferred;
    }

    public void setPersonReferred(String personReferred) {
        this.personReferred = personReferred;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}