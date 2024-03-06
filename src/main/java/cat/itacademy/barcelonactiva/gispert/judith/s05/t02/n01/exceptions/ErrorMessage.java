package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
    private String description;
}
