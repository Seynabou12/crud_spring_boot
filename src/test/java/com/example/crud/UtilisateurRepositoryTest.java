package com.example.crud;

import com.example.crud.utilisateur.Utilisateur;
import com.example.crud.utilisateur.UtilsateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UtilisateurRepositoryTest {

    @Autowired
    private UtilsateurRepository repo;

    @Test
    public void TestAddNew(){
        Utilisateur user = new Utilisateur();
        user.setEmail("dioneseynabou12@gmail.com");
        user.setPassword("seynabou12");
        user.setNom("Dione");
        user.setPrenom("Maimouna");
        user.setTelephone(781794521);

        repo.save(user);
    }

    @Test
    public void testListAll(){
        Iterable<Utilisateur> utilisateurs = repo.findAll();
        for (Utilisateur utilisateur : utilisateurs)
        {
            System.out.println(utilisateur);
        }
    }

    @Test
    public void testUpdate(){
        int userId = 1;
        Optional<Utilisateur> optionalUtilisateur = repo.findById(userId);
        Utilisateur utilisateur = optionalUtilisateur.get();
        utilisateur.setTelephone(768767654);
        repo.save(utilisateur);
        Utilisateur updateUtisateur = repo.findById(userId).get();
    }

    @Test
    public void testGet(){
        int userId = 2;
        Optional<Utilisateur> optionalUtilisateur = repo.findById(userId);
        Utilisateur utilisateur = optionalUtilisateur.get();
        System.out.println(optionalUtilisateur.get());
    }

    @Test
    public void testDelete(){
        int userId = 4;
        repo.deleteById(userId);
        Optional<Utilisateur> optionalUtilisateur = repo.findById(userId);
        System.out.println("utilisateur supprimer avec succés");
    }
}
