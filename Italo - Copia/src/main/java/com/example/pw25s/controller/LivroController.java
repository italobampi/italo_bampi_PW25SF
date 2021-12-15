package com.example.pw25s.controller;

import com.example.pw25s.model.Livro;
import com.example.pw25s.model.dto.LivroSalvarDTO;
import com.example.pw25s.repository.AutorRepository;
import com.example.pw25s.repository.LivroRepository;
import com.example.pw25s.service.AutorService;
import com.example.pw25s.service.LivroService;
import com.example.pw25s.service.impl.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @Autowired
    private AutorService autorService;

    @RequestMapping("/novo")
    public String novoPedido(LivroSalvarDTO livroSalvarDTO, Model model){
        model.addAttribute("autores", autorService.findAll());
        return "livro/formulario";
    }

    @PostMapping(value = "/salvar")
    public String salvarPedido(@Valid LivroSalvarDTO livroSalvarDTO, BindingResult result){
        if(!result.hasErrors()) {
            livroService.save(livroSalvarDTO.toLivro());
        }
        return "home";
    }
    @GetMapping("{id}")
    public String form(@PathVariable Long id, Model model) {

        model.addAttribute("livroSalvarDTO", livroService.findOne(id));

       model.addAttribute("autores", autorService.findOne(livroService.findOne(id).getAutor().getId()));
        return "livro/formulario";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes) {
        System.out.println("\n\n\n\n\n teste \n\n\n\n\n");
        try {
            livroService.delete(id);
            attributes.addFlashAttribute("sucesso",
                    "Registro removido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro",
                    "Falha ao remover o registro!");
        }
        return "redirect:/home";
    }

}
