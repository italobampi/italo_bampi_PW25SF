package com.example.pw25s.controller;

import com.example.pw25s.model.Autor;
import com.example.pw25s.model.dto.AutorSalvarDTO;
import com.example.pw25s.repository.AutorRepository;
import com.example.pw25s.service.AutorService;
import com.example.pw25s.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService autorService;
    @Autowired
    LivroService livroService;

    Autor autor = new Autor();



    @GetMapping("")
    public String autores(Model model){



        model.addAttribute("autores",  autorService.findAll());
        return "autor/homeautor";
    }


    @GetMapping("/cadastro")
    public String novoAutor(AutorSalvarDTO autorSalvarDTO){
        return "autor/autorformulario";
    }

    @PostMapping(value = "/save")
    public String salvarAutor(@Valid AutorSalvarDTO autorSalvarDTO, BindingResult result, Model model){
        if(!result.hasErrors()) {
            autorService.save(autorSalvarDTO.toAutor());
        }

        model.addAttribute("autores",  autorService.findAll());

        return "autor/homeautor";
    }
    @GetMapping("busca/{id}") // /produto/25
    public String busca(@PathVariable Long id,Model model) {

        model.addAttribute("livros",livroService.findLivrosByAutor(autorService.findOne(id)));


        return "home";
    }
    @GetMapping("{id}") // /produto/25
    public String form(@PathVariable Long id, Model model) {

        model.addAttribute("autorSalvarDTO", autorService.findOne(id));


        return "autor/autorformulario";
    }

    @DeleteMapping("delete/{id}") // /produto/25
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes) {

        System.out.println("\n\n\n\n\n teste \n\n\n\n\n");
        try {
            autorService.delete(id);
            attributes.addFlashAttribute("sucesso",
                    "Registro removido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro",
                    "Falha ao remover o registro!");
        }

        return "redirect:/homeautor";
    }
}
