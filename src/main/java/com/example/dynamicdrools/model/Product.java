
package com.example.dynamicdrools.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "price",
    "isAvailable",
    "specs"
})
@Generated("jsonschema2pojo")
public class Product {

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
    @JsonProperty("price")
    private Double price;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("specs")
    private Specs specs;

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

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    public Product withPrice(Double price) {
        this.price = price;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Product withIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

    @JsonProperty("specs")
    public Specs getSpecs() {
        return specs;
    }

    @JsonProperty("specs")
    public void setSpecs(Specs specs) {
        this.specs = specs;
    }

    public Product withSpecs(Specs specs) {
        this.specs = specs;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Product.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        sb.append("isAvailable");
        sb.append('=');
        sb.append(((this.isAvailable == null)?"<null>":this.isAvailable));
        sb.append(',');
        sb.append("specs");
        sb.append('=');
        sb.append(((this.specs == null)?"<null>":this.specs));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.isAvailable == null)? 0 :this.isAvailable.hashCode()));
        result = ((result* 31)+((this.specs == null)? 0 :this.specs.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.isAvailable == rhs.isAvailable)||((this.isAvailable!= null)&&this.isAvailable.equals(rhs.isAvailable))))&&((this.specs == rhs.specs)||((this.specs!= null)&&this.specs.equals(rhs.specs))))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))));
    }

}
