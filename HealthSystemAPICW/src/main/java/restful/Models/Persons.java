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
    private String name;
    private String contactInformation;
    private String address;
    private String age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    
}