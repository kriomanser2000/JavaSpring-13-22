package com.example.javaspr1322.model;

public class Shop
{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String category;
    private String description;
    public Shop(String name, String address, String phone, String email, String website, String category, String description)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
