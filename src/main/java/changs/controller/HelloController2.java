package changs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yincs on 2017/4/8.
 */
@RestController
@RequestMapping("HelloController2")
public class HelloController2 {


    private static final Logger logger = LoggerFactory.getLogger(HelloController2.class);

    public HelloController2() {
        logger.debug("HelloController2() called");
    }


    @RequestMapping("hello1")
    public String hello1() {
        logger.debug("hello1() called");
        return "hello1";
    }

    @RequestMapping("hello2")
    public String hello2() {
        logger.debug("hello2() called");
        return "hello1";
    }

    @RequestMapping("hello3")
    public String hello3() {
        logger.debug("hello3() called");
        return "hello1";
    }
}
