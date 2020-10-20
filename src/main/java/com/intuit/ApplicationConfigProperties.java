package com.intuit;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.ComponentScan;
import com.intuit.platform.jsk.config.client.idps.autoconfig.IdpsConnectionProperties;

@Component
@ComponentScan(basePackages = {"com.intuit.demo"})
@EnableConfigurationProperties({IdpsConnectionProperties.class})
public class ApplicationConfigProperties {

}
