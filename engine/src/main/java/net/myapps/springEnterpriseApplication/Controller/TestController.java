package net.myapps.springEnterpriseApplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rmandada
 */
@RestController
public class TestController {
    @RequestMapping(value = "/hey")
    public String getHello() {
        return  "Hello From Spring";
    }
}
