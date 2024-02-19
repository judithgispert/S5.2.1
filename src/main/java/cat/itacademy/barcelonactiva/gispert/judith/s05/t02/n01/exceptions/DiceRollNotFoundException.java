package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions;

public class DiceRollNotFoundException extends RuntimeException{
    public DiceRollNotFoundException (String errorMessage){
        super (errorMessage);
    }
}
