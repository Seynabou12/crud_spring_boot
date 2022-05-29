package com.example.crud.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<Utilisateur> listUser = utilisateurService.ListUtilisateur();
        model.addAttribute("listUser", listUser);
        return  "utilisateur";
    }

    @GetMapping("/users/add")
    public String showNewForm(Model model){
        model.addAttribute("user" , new Utilisateur());
        return "user_form";
    }

    @PostMapping("/users/save")
    public  String userSave( @ModelAttribute("user") Utilisateur utilisateur){
        utilisateurService.save(utilisateur);
        return "redirect:/users";
    }

}
