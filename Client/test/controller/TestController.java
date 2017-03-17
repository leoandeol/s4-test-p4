package controller;

import model.Messagerie;
import static org.junit.Assert.*;

import org.junit.Test;
import view.Fenetre;

public class TestController {

    Exception ex;

    @Test
    public void test() {
        try {
            Messagerie m = new Messagerie();
            Fenetre f = new Fenetre(m);
            Controller.generateController(m, f);
        } catch (Exception e) {
            ex = e;
        }
        assertEquals(null, ex);
    }

}
