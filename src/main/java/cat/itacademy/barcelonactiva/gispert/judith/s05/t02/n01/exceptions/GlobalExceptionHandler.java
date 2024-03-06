package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DiceRollNotFoundException.class)
    public ResponseEntity<ErrorMessage>diceRollNotFoundException
            (DiceRollNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<ErrorMessage>playerNotFoundException
            (PlayerNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> emailAlreadyExistException
            (EmailAlreadyExistException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PlayerNameAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> playerNameAlreadyExistException
            (PlayerNameAlreadyExistException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }
}
