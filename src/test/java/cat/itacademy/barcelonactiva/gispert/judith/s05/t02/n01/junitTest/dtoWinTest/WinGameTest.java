package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.junitTest.dtoWinTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinGameTest {
    @Test
    void isWinTest (){
        DiceRollDTO diceRollDTO = new DiceRollDTO(1,6);
        Assertions.assertEquals(7, diceRollDTO.getDice1() + diceRollDTO.getDice2());
    }

    @Test
    void isLoseTest(){
        DiceRollDTO diceRollDTO = new DiceRollDTO(1,4);
        Assertions.assertTrue(diceRollDTO.getDice1() + diceRollDTO.getDice2() != 7);
    }
}
