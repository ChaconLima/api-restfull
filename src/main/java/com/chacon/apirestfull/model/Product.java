package com.chacon.apirestfull.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_TB")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private BigDecimal quantidiry;
    private BigDecimal value;

 
    //functions get returns
    public long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public BigDecimal getQuantidiry() {
        return quantidiry;
    }

    public BigDecimal getValue() {
        return value;
    }

    //functions set returns
    public void setId(long id){
        this.id= id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantidiry(BigDecimal quantidiry) {
        this.quantidiry = quantidiry;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
