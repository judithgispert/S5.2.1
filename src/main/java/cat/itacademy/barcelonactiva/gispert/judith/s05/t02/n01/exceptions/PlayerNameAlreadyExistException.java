package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions;

public class PlayerNameAlreadyExistException extends RuntimeException{
    public PlayerNameAlreadyExistException(String errorMessage){
        super (errorMessage);
    }
}
