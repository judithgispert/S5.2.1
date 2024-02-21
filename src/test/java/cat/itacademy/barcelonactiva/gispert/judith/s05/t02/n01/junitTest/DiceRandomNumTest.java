package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.junitTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.methods.DiceRandomNum;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceRandomNumTest {
    @Test
    void testRandomNum(){
        int diceNumber = DiceRandomNum.randomNum();
        Assertions.assertTrue(diceNumber > 0 && diceNumber <= 6);
    }
}
