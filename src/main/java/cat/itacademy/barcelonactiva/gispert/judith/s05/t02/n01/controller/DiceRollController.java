package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/gameDiceRoll")
public class DiceRollController {
    @GetMapping()
    public String startWeb(){
        return "startWeb";
    }
}
