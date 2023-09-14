package application.controller;

import org.springframework.brans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.GeneroRepository;

@Controller
@RequestMapping("/genero")
public class GeneroController{
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("generos", generoRepo.findAll());
        return "/genero/list"
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    PUBLIC String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);

        generoRepo.save(genero);

        return "redirect:/genero/list"
    }
}