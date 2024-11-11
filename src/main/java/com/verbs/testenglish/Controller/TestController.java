package com.verbs.testenglish.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/tests")
    public String tests() {
        return "tests";
    }
}
