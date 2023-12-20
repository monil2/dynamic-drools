
package com.example.dynamicdrools.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "foundedYear",
    "isActive",
    "revenue",
    "employees",
    "locations",
    "products"
})
@Generated("jsonschema2pojo")
public class Company {

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
    @JsonProperty("foundedYear")
    private Double foundedYear;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isActive")
    private Boolean isActive;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("revenue")
    private Double revenue;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employees")
    private List<Employee> employees = new ArrayList<Employee>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locations")
    private Locations locations;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("products")
    private List<Product> products = new ArrayList<Product>();

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

    public Company withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("foundedYear")
    public Double getFoundedYear() {
        return foundedYear;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("foundedYear")
    public void setFoundedYear(Double foundedYear) {
        this.foundedYear = foundedYear;
    }

    public Company withFoundedYear(Double foundedYear) {
        this.foundedYear = foundedYear;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Company withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("revenue")
    public Double getRevenue() {
        return revenue;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("revenue")
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Company withRevenue(Double revenue) {
        this.revenue = revenue;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employees")
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company withEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locations")
    public Locations getLocations() {
        return locations;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locations")
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public Company withLocations(Locations locations) {
        this.locations = locations;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Company withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("foundedYear");
        sb.append('=');
        sb.append(((this.foundedYear == null)?"<null>":this.foundedYear));
        sb.append(',');
        sb.append("isActive");
        sb.append('=');
        sb.append(((this.isActive == null)?"<null>":this.isActive));
        sb.append(',');
        sb.append("revenue");
        sb.append('=');
        sb.append(((this.revenue == null)?"<null>":this.revenue));
        sb.append(',');
        sb.append("employees");
        sb.append('=');
        sb.append(((this.employees == null)?"<null>":this.employees));
        sb.append(',');
        sb.append("locations");
        sb.append('=');
        sb.append(((this.locations == null)?"<null>":this.locations));
        sb.append(',');
        sb.append("products");
        sb.append('=');
        sb.append(((this.products == null)?"<null>":this.products));
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
        result = ((result* 31)+((this.revenue == null)? 0 :this.revenue.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.locations == null)? 0 :this.locations.hashCode()));
        result = ((result* 31)+((this.isActive == null)? 0 :this.isActive.hashCode()));
        result = ((result* 31)+((this.employees == null)? 0 :this.employees.hashCode()));
        result = ((result* 31)+((this.foundedYear == null)? 0 :this.foundedYear.hashCode()));
        result = ((result* 31)+((this.products == null)? 0 :this.products.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Company) == false) {
            return false;
        }
        Company rhs = ((Company) other);
        return ((((((((this.revenue == rhs.revenue)||((this.revenue!= null)&&this.revenue.equals(rhs.revenue)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.locations == rhs.locations)||((this.locations!= null)&&this.locations.equals(rhs.locations))))&&((this.isActive == rhs.isActive)||((this.isActive!= null)&&this.isActive.equals(rhs.isActive))))&&((this.employees == rhs.employees)||((this.employees!= null)&&this.employees.equals(rhs.employees))))&&((this.foundedYear == rhs.foundedYear)||((this.foundedYear!= null)&&this.foundedYear.equals(rhs.foundedYear))))&&((this.products == rhs.products)||((this.products!= null)&&this.products.equals(rhs.products))));
    }

}
