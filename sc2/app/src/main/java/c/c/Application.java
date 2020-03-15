package c.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by admin
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients("c.c.feign")
public class Application {

    public static void main(String args[]){

        SpringApplication.run(Application.class,args);

    }


}
