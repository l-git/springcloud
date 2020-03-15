package c.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by admin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {

    public static void main(String args[]){

        SpringApplication.run(ProductApplication.class,args);

    }


}
