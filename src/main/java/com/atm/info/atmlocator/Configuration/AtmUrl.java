package com.atm.info.atmlocator.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="atm.url")
@Data
public class AtmUrl {
    private String openweb;

}
