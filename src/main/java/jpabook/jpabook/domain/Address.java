package jpabook.jpabook.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipconde;

    protected Address(){
    }

    public Address(String city, String street, String zipconde){
        this.city = city;
        this.street = street;
        this.zipconde = zipconde;
    }
}
