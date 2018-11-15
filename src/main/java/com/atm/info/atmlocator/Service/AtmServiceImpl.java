package com.atm.info.atmlocator.Service;

import com.atm.info.atmlocator.Model.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class AtmServiceImpl implements AtmService  {

    private RestTemplate restTemplate ;

    @Autowired
    public AtmServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<Atm> getAtmList() {
        ResponseEntity<Atm[]> responseEntity = restTemplate.
                getForEntity("https://apis-bank-dev.apigee.net/apis/v1/locations/atms", Atm[].class);

        return Arrays.asList(responseEntity.getBody());
    }
}
