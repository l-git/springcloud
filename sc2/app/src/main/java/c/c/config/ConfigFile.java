package c.c.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin
 */
@Configuration
public class ConfigFile {


    @Bean
    public RestTemplate grestTemplate(){
        return new RestTemplate();
    }


}
