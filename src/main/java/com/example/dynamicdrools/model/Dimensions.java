
package com.example.dynamicdrools.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "length",
    "width",
    "height"
})
@Generated("jsonschema2pojo")
public class Dimensions {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("length")
    private Double length;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("width")
    private Double width;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("height")
    private Double height;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("length")
    public Double getLength() {
        return length;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("length")
    public void setLength(Double length) {
        this.length = length;
    }

    public Dimensions withLength(Double length) {
        this.length = length;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("width")
    public Double getWidth() {
        return width;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("width")
    public void setWidth(Double width) {
        this.width = width;
    }

    public Dimensions withWidth(Double width) {
        this.width = width;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("height")
    public Double getHeight() {
        return height;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("height")
    public void setHeight(Double height) {
        this.height = height;
    }

    public Dimensions withHeight(Double height) {
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Dimensions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("length");
        sb.append('=');
        sb.append(((this.length == null)?"<null>":this.length));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
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
        result = ((result* 31)+((this.length == null)? 0 :this.length.hashCode()));
        result = ((result* 31)+((this.width == null)? 0 :this.width.hashCode()));
        result = ((result* 31)+((this.height == null)? 0 :this.height.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Dimensions) == false) {
            return false;
        }
        Dimensions rhs = ((Dimensions) other);
        return ((((this.length == rhs.length)||((this.length!= null)&&this.length.equals(rhs.length)))&&((this.width == rhs.width)||((this.width!= null)&&this.width.equals(rhs.width))))&&((this.height == rhs.height)||((this.height!= null)&&this.height.equals(rhs.height))));
    }

}
