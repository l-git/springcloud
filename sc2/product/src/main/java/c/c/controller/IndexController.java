package c.c.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin
 */

@RestController
public class IndexController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    static List<String> projectList=new ArrayList<>();

    static {

        for(int i=0;i<5;i++){
            projectList.add("p"+i);
        }

    }




    @RequestMapping("/products")
    public Object productList(){
        logger.info("projectList ");
        return projectList;
    }


}
