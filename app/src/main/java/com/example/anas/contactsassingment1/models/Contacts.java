package com.example.anas.contactsassingment1.models;

/**
 * Created by Anas on 29/09/2017.
 */

public class Contacts {
    private int id;
    private String name;
    private String  phone;
    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }


    public Contacts(int id, String name, String phone, String gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
