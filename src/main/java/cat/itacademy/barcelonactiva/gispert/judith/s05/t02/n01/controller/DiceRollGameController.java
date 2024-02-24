package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gameDiceRoll")
@RequiredArgsConstructor
public class DiceRollGameController {
    @Autowired
    private final IPlayerService playerService;

    @PostMapping("/createPlayer")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerDTO playerDTO){
        playerService.addPlayer(playerDTO);
        return new ResponseEntity<>("Player created successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable("id") int id, @RequestBody PlayerDTO newPlayerDTO){
        PlayerDTO playerDTO = playerService.updatePlayer(newPlayerDTO, id);
        if (playerDTO!=null){
            return new ResponseEntity<>("Player updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player not found.", HttpStatus.OK);
        }
    }

    @PostMapping("/play/{id}")
    public ResponseEntity<DiceRollDTO> playDiceRoll(@PathVariable("id") int id){
        DiceRollDTO gameDiceRoll = playerService.play(id);
        return new ResponseEntity<>(gameDiceRoll, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGames/{id}")
    public ResponseEntity<String> deleteGames(@PathVariable("id") int id){
        playerService.deleteGames(id);
        return new ResponseEntity<>("Games deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getPlayers(){
        List<Player> players = playerService.getPlayers();
        if(players.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }

    @GetMapping("/getGames/{id}")
    public ResponseEntity<List<DiceRollDTO>> getGames(@PathVariable("id") int id){
        List<DiceRollDTO> gamesDTO = playerService.getGames(id);
        if(gamesDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(gamesDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<PlayerDTO>> getRanking(){
        List<PlayerDTO> playersRanking = playerService.getRanking();
        if(playersRanking.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(playersRanking, HttpStatus.OK);
        }
    }

    @GetMapping("/rankingPercentage")
    public ResponseEntity<Double> getRankingPercentage(){
        double rankingPercentage = playerService.getPercentageRanking();
        return new ResponseEntity<>(rankingPercentage, HttpStatus.OK);
    }

    @GetMapping("/getLoser")
    public ResponseEntity<PlayerDTO> getLoser(){
        PlayerDTO loser = playerService.getLoser();
        return new ResponseEntity<>(loser, HttpStatus.OK);
    }

    @GetMapping("/getWinner")
    public ResponseEntity<PlayerDTO> getWinner(){
        PlayerDTO winner = playerService.getWinner();
        return new ResponseEntity<>(winner, HttpStatus.OK);
    }
}
