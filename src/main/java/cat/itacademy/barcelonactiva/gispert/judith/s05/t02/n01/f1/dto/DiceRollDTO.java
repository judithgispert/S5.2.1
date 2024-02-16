package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.methods.DiceRandomNum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiceRollDTO {
    private int idDiceRoll;
    private int dice1;
    private int dice2;
    private boolean resultWin;

    public DiceRollDTO (){
        this.dice1 = DiceRandomNum.randomNum();
        this.dice2 = DiceRandomNum.randomNum();
        this.resultWin = winGame();
    }

    public boolean winGame(){
        boolean win;
        if(dice1 + dice2==7){
            win = true;
        } else {
            win = false;
        }
        return win;
    }
}
