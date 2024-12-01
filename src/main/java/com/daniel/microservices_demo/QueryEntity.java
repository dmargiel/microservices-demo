package com.daniel.microservices_demo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QueryEntity implements Serializable {

    @Id @GeneratedValue 
    private Long id;
    private String query;
    private String response;
    private Date queryDate;

    public QueryEntity() {
        // this.queryDate = new Date();
    }

    public QueryEntity(String query, String response) {
        this.queryDate = new Date();
        this.query = query;
        this.response = response;
    }
    
}
