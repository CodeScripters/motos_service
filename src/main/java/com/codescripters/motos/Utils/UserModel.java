package com.codescripters.motos.Utils;

import com.codescripters.motos.Motorcycle.Motorcycle;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class UserModel {
private BigInteger documentNumber;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Role role;
    private BigInteger licenseNumber;
    private String address;
    private String city;
    private String dateOfBirth;
    private BigInteger phoneNumber;
    private String emailAddress;
    private Motorcycle motorcycle;
    private String createdBy;
    private String createdAt;
    private String updatedAt;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public BigInteger getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(BigInteger documentNumber) {
        this.documentNumber = documentNumber;
    }

    public BigInteger getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(BigInteger licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
