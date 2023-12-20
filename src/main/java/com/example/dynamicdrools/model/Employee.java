
package com.example.dynamicdrools.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "age",
    "isManager",
    "skills",
    "contact"
})
@Generated("jsonschema2pojo")
public class Employee {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private Double id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("age")
    private Double age;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isManager")
    private Boolean isManager;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("skills")
    private List<String> skills = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contact")
    private Contact contact;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Double getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Double id) {
        this.id = id;
    }

    public Employee withId(Double id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Employee withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("age")
    public Double getAge() {
        return age;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("age")
    public void setAge(Double age) {
        this.age = age;
    }

    public Employee withAge(Double age) {
        this.age = age;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isManager")
    public Boolean getIsManager() {
        return isManager;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isManager")
    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public Employee withIsManager(Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("skills")
    public List<String> getSkills() {
        return skills;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("skills")
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Employee withSkills(List<String> skills) {
        this.skills = skills;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Employee withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("isManager");
        sb.append('=');
        sb.append(((this.isManager == null)?"<null>":this.isManager));
        sb.append(',');
        sb.append("skills");
        sb.append('=');
        sb.append(((this.skills == null)?"<null>":this.skills));
        sb.append(',');
        sb.append("contact");
        sb.append('=');
        sb.append(((this.contact == null)?"<null>":this.contact));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.skills == null)? 0 :this.skills.hashCode()));
        result = ((result* 31)+((this.contact == null)? 0 :this.contact.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.isManager == null)? 0 :this.isManager.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.age == null)? 0 :this.age.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employee) == false) {
            return false;
        }
        Employee rhs = ((Employee) other);
        return (((((((this.skills == rhs.skills)||((this.skills!= null)&&this.skills.equals(rhs.skills)))&&((this.contact == rhs.contact)||((this.contact!= null)&&this.contact.equals(rhs.contact))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.isManager == rhs.isManager)||((this.isManager!= null)&&this.isManager.equals(rhs.isManager))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.age == rhs.age)||((this.age!= null)&&this.age.equals(rhs.age))));
    }

}
