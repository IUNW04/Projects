/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restful.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author imadhuddin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persons {
    private int id;
    private String age;
    private String name;
    private String contactInformation;
    private String address;
  private String gender;
    public Persons() {
    }

    public Persons(int id, String age, String name, String contactInformation, String address, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
        this.gender = gender;
    }

    
    
    public Persons(int id, String name, String contactInformation, String address) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
        
    }
        public Persons(int id, String name, String contactInformation) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;

        
    }
    
    
        public Persons(int id, String name,  String age, String gender, String contactInformation) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
        this.age = age;
        this.gender = gender;
    }

@JsonInclude(JsonInclude.Include.NON_NULL)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
@JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}