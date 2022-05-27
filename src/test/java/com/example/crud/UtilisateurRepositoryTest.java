package com.example.crud;

import com.example.crud.utilisateur.Utilisateur;
import com.example.crud.utilisateur.UtilsateurRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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
        user.setPrenom("Seynabou");
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
}
