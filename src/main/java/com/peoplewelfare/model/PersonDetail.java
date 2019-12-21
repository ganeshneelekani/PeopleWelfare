package com.peoplewelfare.model;

import javax.persistence.*;
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

    @Column(name = "PERSON_JOINED_DATE")
    @Temporal(TemporalType.DATE)
    private Date personJoinedDate;

    @Column(name = "PERSON_GENDER")
    private String gender;

    @Column(name = "PERSON_ADDRESS")
    private String personAddress;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PINCODE")
    private String pinCode;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "NOMINEE")
    private String nominee;

    @Column(name = "NOMINEE_RELATION")
    private String nomineeRelation;

    @Column(name = "PERSON_PASSWORD")
    private String password;

    @Column(name = "PARENT_REFERENCE")
    private String parentReference;

    @Column(name = "PERSON_ROLE")
    private String role;

    @Transient
    private String verifyPassword;

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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public String getParentReference() {
        return parentReference;
    }

    public void setParentReference(String parentReference) {
        this.parentReference = parentReference;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Date getPersonJoinedDate() {
        return personJoinedDate;
    }

    public void setPersonJoinedDate(Date personJoinedDate) {
        this.personJoinedDate = personJoinedDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}