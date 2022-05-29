package com.example.crud.utilisateur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Utilisateur get(int id) throws UtilisateurNotFoundException {
        Optional<Utilisateur> result =repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw  new UtilisateurNotFoundException("Could ot found any users with ID" + id);
    }

    public void delete(int id) throws UtilisateurNotFoundException {
       Long count =  repo.countById(id);
       if (count == null || count == 0){
           throw  new UtilisateurNotFoundException("Could ot found any users with ID" + id);
       }
        repo.deleteById(id);
    }
}
