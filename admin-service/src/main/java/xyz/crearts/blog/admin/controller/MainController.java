package xyz.crearts.blog.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    @GetMapping({"", "/", "index.html"})
    public String getIndex(Model model) {
        model.addAttribute("page", "main");

        return "index";
    }

    @RequestMapping("/{page}.html")
    public String advice(Model model, @PathVariable String page) {
        return configure(model, page);
    }

    private String configure(Model model, String page) {
        model.addAttribute("page", page);

        switch (page) {
            case "articles", "blog":
                model.addAttribute("plugins", Collections.singleton("database"));
                break;
            default:
                break;
        }

        return "index";
    }
}
