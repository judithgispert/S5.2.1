package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String errorMessage){
        super (errorMessage);
    }
}
