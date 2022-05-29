package com.example.crud.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public  String userSave(@ModelAttribute("user") Utilisateur utilisateur, RedirectAttributes redirectAttributes){
        utilisateurService.save(utilisateur);
        redirectAttributes.addFlashAttribute("message", "Un nouveau utilisateur ajouter avec succés");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model , RedirectAttributes redirectAttributes) {
        Utilisateur utilisateur = null;
        try {
            utilisateur = utilisateurService.get(id);
            model.addAttribute("user", utilisateur);
            return "user_form";
        } catch (UtilisateurNotFoundException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }

    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Utilisateur utilisateur = null;
        try {
            utilisateurService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Utilisateur qui à Id" + id + "est supprimer");
        } catch (UtilisateurNotFoundException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/users";
    }
}
