package com.example.crud.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilsateurService utilsateurService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<Utilisateur> listUser = utilsateurService.ListUtilisateur();
        model.addAttribute("listUser", listUser);
        return  "utilisateur";
    }

    @GetMapping("/users/add")
    public String showNewForm(Model model){
        model.addAttribute("user" , new Utilisateur());
        return "user_form";
    }
}
