package changs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yincs on 2017/4/8.
 */

@RestController
@RequestMapping("view")
public class ViewController {

    @RequestMapping("login")
    public String loginView() {
        return "please login";
    }

    @RequestMapping("unauthorized")
    public String unauthorizedViewView() {
        return "unauthorizedView";
    }

}
