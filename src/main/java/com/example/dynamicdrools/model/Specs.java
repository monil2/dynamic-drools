
package com.example.dynamicdrools.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weight",
    "dimensions"
})
@Generated("jsonschema2pojo")
public class Specs {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weight")
    private Double weight;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dimensions")
    private Dimensions dimensions;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Specs withWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dimensions")
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dimensions")
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Specs withDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Specs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("weight");
        sb.append('=');
        sb.append(((this.weight == null)?"<null>":this.weight));
        sb.append(',');
        sb.append("dimensions");
        sb.append('=');
        sb.append(((this.dimensions == null)?"<null>":this.dimensions));
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
        result = ((result* 31)+((this.weight == null)? 0 :this.weight.hashCode()));
        result = ((result* 31)+((this.dimensions == null)? 0 :this.dimensions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Specs) == false) {
            return false;
        }
        Specs rhs = ((Specs) other);
        return (((this.weight == rhs.weight)||((this.weight!= null)&&this.weight.equals(rhs.weight)))&&((this.dimensions == rhs.dimensions)||((this.dimensions!= null)&&this.dimensions.equals(rhs.dimensions))));
    }

}
