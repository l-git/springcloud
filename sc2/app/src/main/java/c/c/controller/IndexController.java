package c.c.controller;

import c.c.feign.RibbonProxyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin
 */

@RestController
public class IndexController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private RibbonProxyService ribbonProxyService;

    @RequestMapping(value = "")
    public Object index(){

        Object o=ribbonProxyService.products();
        return o;
    }

    @RequestMapping(value = "getProduct")
    public Object getProduct(){
        ResponseEntity<String> responseEntity= restTemplate.getForEntity("http://localhost:8088/products", String.class);
        return responseEntity.getBody();
    }


    @RequestMapping(value = "faultTolerance")
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfigurations")
    public Object faultTolerance(){

        if(true){
            throw new RuntimeException("hystrix test");
        }

        return null;
    }

    public Object fallbackRetrieveConfigurations()
    {
//returning the default configuration
        return "this is from fallbackRetrieveConfigurations";
    }

}
