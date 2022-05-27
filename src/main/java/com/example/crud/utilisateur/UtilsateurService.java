package com.example.crud.utilisateur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilsateurService {

    @Autowired
    private UtilsateurRepository repo;

    public List<Utilisateur> ListUtilisateur(){
        return (List<Utilisateur>) repo.findAll();
    }
}
