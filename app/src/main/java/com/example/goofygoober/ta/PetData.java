package com.example.goofygoober.ta;

import com.orm.SugarRecord;

/**
 * Created by Faldy on 18/05/2017.
 */

public class PetData extends SugarRecord<PetData> {
    String name;
    String type;
    String gender;
    String dateOfBirth;
    String breed;
    String color;
    Integer bath;
    Integer vaccine;
    Integer fleas;
    String bathPer;
    String vaccinePer;
    String fleasPer;
    byte[] image;

    public PetData() {
    }

    public PetData(String name, String type, String gender, String dateOfBirth, String breed, String color, Integer bath, Integer vaccine, Integer fleas, String bathPer, String vaccinePer, String fleasPer, byte[] image) {
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.color = color;
        this.bath = bath;
        this.vaccine = vaccine;
        this.fleas = fleas;
        this.bathPer = bathPer;
        this.vaccinePer = vaccinePer;
        this.fleasPer = fleasPer;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getBath() {
        return bath;
    }

    public void setBath(Integer bath) {
        this.bath = bath;
    }

    public Integer getVaccine() {
        return vaccine;
    }

    public void setVaccine(Integer vaccine) {
        this.vaccine = vaccine;
    }

    public Integer getFleas() {
        return fleas;
    }

    public void setFleas(Integer fleas) {
        this.fleas = fleas;
    }

    public String getBathPer() {
        return bathPer;
    }

    public void setBathPer(String bathPer) {
        this.bathPer = bathPer;
    }

    public String getVaccinePer() {
        return vaccinePer;
    }

    public void setVaccinePer(String vaccinePer) {
        this.vaccinePer = vaccinePer;
    }

    public String getFleasPer() {
        return fleasPer;
    }

    public void setFleasPer(String fleasPer) {
        this.fleasPer = fleasPer;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
