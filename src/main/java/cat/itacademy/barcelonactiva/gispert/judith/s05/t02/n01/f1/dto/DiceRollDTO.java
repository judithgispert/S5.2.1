package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.methods.DiceRandomNum;

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

    public int getIdDiceRoll() {
        return idDiceRoll;
    }
    public int getDice1() {
        return dice1;
    }
    public int getDice2() {
        return dice2;
    }
    public boolean getResultWin() {
        return resultWin;
    }

    public void setIdDiceRoll(int idDiceRoll) {
        this.idDiceRoll = idDiceRoll;
    }
    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }
    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }
    public void setResultWin(boolean resultWin) {
        this.resultWin = resultWin;
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
