
package com.example.dynamicdrools.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "headquarters",
    "branches"
})
@Generated("jsonschema2pojo")
public class Locations {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("headquarters")
    private Headquarters headquarters;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("branches")
    private List<Branch> branches = new ArrayList<Branch>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("headquarters")
    public Headquarters getHeadquarters() {
        return headquarters;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("headquarters")
    public void setHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
    }

    public Locations withHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("branches")
    public List<Branch> getBranches() {
        return branches;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("branches")
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Locations withBranches(List<Branch> branches) {
        this.branches = branches;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locations.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("headquarters");
        sb.append('=');
        sb.append(((this.headquarters == null)?"<null>":this.headquarters));
        sb.append(',');
        sb.append("branches");
        sb.append('=');
        sb.append(((this.branches == null)?"<null>":this.branches));
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
        result = ((result* 31)+((this.branches == null)? 0 :this.branches.hashCode()));
        result = ((result* 31)+((this.headquarters == null)? 0 :this.headquarters.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Locations) == false) {
            return false;
        }
        Locations rhs = ((Locations) other);
        return (((this.branches == rhs.branches)||((this.branches!= null)&&this.branches.equals(rhs.branches)))&&((this.headquarters == rhs.headquarters)||((this.headquarters!= null)&&this.headquarters.equals(rhs.headquarters))));
    }

}
