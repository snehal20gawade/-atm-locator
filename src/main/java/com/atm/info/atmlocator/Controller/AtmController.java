package com.atm.info.atmlocator.Controller;

import com.atm.info.atmlocator.Model.Atm;
import com.atm.info.atmlocator.Model.Currency;
import com.atm.info.atmlocator.Service.AtmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atm")
public class AtmController {

    private AtmServiceImpl atmService ;

    @Autowired
     public AtmController(AtmServiceImpl atmService){
         this.atmService = atmService ;

     }

     @GetMapping
     public List<Atm> getAtmList(){
        return atmService.getAtmList();
    }

    @GetMapping("/currency/{currency}")
    public List<Atm> getAtmListByCurrency(@PathVariable Currency currency){
        List<Atm> atms = atmService.getAtmList();
       List<Atm> filteredList = atms.stream()
               .filter(atm -> atm.getCurrency().equals(currency))
               .collect(Collectors.toList());
       return  filteredList ;
    }


}
