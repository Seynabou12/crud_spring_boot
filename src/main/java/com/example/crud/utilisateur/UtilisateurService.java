package com.example.crud.utilisateur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository repo;

    public List<Utilisateur> ListUtilisateur(){
        return (List<Utilisateur>) repo.findAll();
    }

    public void save(Utilisateur utilisateur) {
        repo.save(utilisateur);
    }
}