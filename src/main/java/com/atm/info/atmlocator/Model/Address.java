package com.atm.info.atmlocator.Model;

import lombok.Data;

@Data
public class Address {
    private  String street ;
    private  String housenumber ;
    private  String postalcode ;
    private  String city ;
    private Location geolocation ;
}
