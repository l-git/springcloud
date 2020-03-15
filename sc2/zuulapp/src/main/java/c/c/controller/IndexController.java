package c.c.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin
 */
@RestController
public class IndexController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public Object index(){

        return "zuul index";
    }


}
