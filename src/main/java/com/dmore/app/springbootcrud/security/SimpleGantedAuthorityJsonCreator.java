package com.dmore.app.springbootcrud.security;



import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGantedAuthorityJsonCreator {

    public SimpleGantedAuthorityJsonCreator(@JsonProperty("authority") String role) {
    }

}
