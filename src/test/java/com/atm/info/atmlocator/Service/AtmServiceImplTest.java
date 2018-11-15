package com.atm.info.atmlocator.Service;

import com.atm.info.atmlocator.Configuration.AtmUrl;
import com.atm.info.atmlocator.Model.Atm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtmServiceImplTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private AtmUrl atmurl;
    @Mock
    private RestTemplateBuilder restTemplateBuilder;
    @Mock
    ResponseEntity responseEntity;

    ObjectMapper objectMapper;

    private AtmService atmService;

    private static String atmUrl = "http://localhost:8888/test";

    @Before
    public void setup() {
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        atmService = new AtmServiceImpl(restTemplateBuilder, atmurl);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAtmList() throws JsonProcessingException {
        when(atmurl.getOpenweb()).thenReturn(atmUrl);
        when(restTemplate.getForEntity(atmUrl, Atm[].class)).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(expectedAtms());
        List<Atm> actualList = atmService.getAtmList();
        assertThat(actualList, hasSize(1));
    }

    private Atm[] expectedAtms() {
        Atm atm = new Atm();
        Atm[] atms = new  Atm[1];
        atms[0] = atm;
        return atms;
    }


}