package com.verbs.testenglish.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TreeController {
    @GetMapping("/binarytree")
    public String tree() {
        return "binarytree";
    }
}
