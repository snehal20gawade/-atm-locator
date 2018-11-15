package com.atm.info.atmlocator.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Atm  {
    private String name ;
    private Access access ;
    private String  address ;
    private Currency currency;
    private boolean isWithdrawalCharged;
    private Location location;
    private String status;
    private Timings timings;

}
