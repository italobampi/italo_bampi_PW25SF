package com.example.pw25s.controller;


import com.example.pw25s.repository.LivroRepository;
import com.example.pw25s.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    LivroService livroService;

    @GetMapping(value = {"","/home"})
    public String home(Model model) {
        model.addAttribute("livros",  livroService.findAll());
        return "home";
    }

}
