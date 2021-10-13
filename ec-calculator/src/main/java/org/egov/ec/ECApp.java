package org.egov.ec;


import org.egov.tracer.config.TracerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ TracerConfiguration.class })
public class ECApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ECApp.class, args);
    }

}
