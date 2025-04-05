package com.gdu_springboot.springboot_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{3,}",message = "Vui long dien day du thong tin")
    @Column(name= "name_company")
    private String name_company;

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{3,}",message = "Vui long dien day du thong tin")
    @Column(name= "street_address")
    private String street_address;

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z ]{3,}",message = "Vui long dien day du thong tin")
    @Column(name= "city")
    private String city;

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z ]{3,}",message = "Vui long dien day du thong tin")
    @Column(name= "region")
    private String region;

    @NotNull(message="is required")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9 ]{5}$",message = "Chi nhap 5 ki tu chu hoac so")
    @Column(name= "post_code")
    private String post_code;

    @NotNull(message="is required")
    @Pattern(regexp = "^[a-zA-Z ]{3,}",message = "Vui long dien day du thong tin")
    @Column(name = "country")
    private String country;

    public Customer(){
    }

    public Customer(String name_company, String street_address, String city, String region, String post_code, String country) {
        this.name_company = name_company;
        this.street_address = street_address;
        this.city = city;
        this.region = region;
        this.post_code = post_code;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name_company='" + name_company + '\'' +
                ", street_address='" + street_address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", post_code='" + post_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
