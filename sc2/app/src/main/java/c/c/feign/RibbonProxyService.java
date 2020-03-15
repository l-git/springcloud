package c.c.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by admin
 */

@FeignClient(name="product")
//enabling ribbon
@RibbonClient(name="product")
public interface RibbonProxyService {

    @GetMapping("/products")
    Object products();

}
