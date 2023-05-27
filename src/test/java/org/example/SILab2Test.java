package org.example;
import org.example.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    User nullKorisnik = null;
    User georgina = new User("georgina", "nina111@a", "georgina@yahoo.com");
    User geo = new User("geo", "hotm geogeo222", "geotmailcom");
    User gorge = new User(null, "georgina222@", "gege@gmail,com");
    User []users = {new User("george", null, "george@ymail.com"), new User("george23@", null, null), new User(null, null, "george@ymail.com")};
    User pass = new User("georgi", null,"gmail@gmail.com");
    User mail = new User("nina", "nina000*a",null);

    @Test
    void everyBranch() {
        assertThrows(RuntimeException.class, ()-> SILab2.function(nullKorisnik, null));
        assertTrue(() -> SILab2.function(georgina, new ArrayList<>()));
        assertFalse(() -> SILab2.function(gorge, List.of(users)));
        assertFalse(() -> SILab2.function(geo, List.of(users)));
    }
    @Test
    void multipleCondition() {
        assertThrows(RuntimeException.class, ()->SILab2.function(nullKorisnik, new ArrayList<>()));
        assertThrows(RuntimeException.class, ()->SILab2.function(pass, new ArrayList<>()));
        assertThrows(RuntimeException.class, ()->SILab2.function(mail, new ArrayList<>()));
        //assertFalse(()->SILab2.function(new User("georgina", "geprgina@123", "georgina@gmail.com"), new ArrayList<>()));
    }
}