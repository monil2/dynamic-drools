
package com.example.dynamicdrools.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Generated schema for Root
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "company"
})
@Generated("jsonschema2pojo")
public class DynamicClass {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    private Company company;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    public DynamicClass withCompany(Company company) {
        this.company = company;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DynamicClass.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null)?"<null>":this.company));
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
        result = ((result* 31)+((this.company == null)? 0 :this.company.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DynamicClass) == false) {
            return false;
        }
        DynamicClass rhs = ((DynamicClass) other);
        return ((this.company == rhs.company)||((this.company!= null)&&this.company.equals(rhs.company)));
    }

}
