package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.junitTest.serviceImplTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository.IDiceRollRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IDiceRollService;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl.DiceRollServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DiceRollServiceImplTest {
    @Mock
    private IDiceRollRepository diceRollRepository;

    @InjectMocks
    private IDiceRollService diceRollService = new DiceRollServiceImpl(diceRollRepository);

    private Player player;
    private final List<DiceRoll> games = new ArrayList<>();
    @BeforeEach
    void setUp(){
        player = new Player();
        DiceRoll diceRollGame1 = new DiceRoll(player);
        games.add(diceRollGame1);
        DiceRoll diceRollGame2 = new DiceRoll(player);
        games.add(diceRollGame2);
        DiceRoll diceRollGame3 = new DiceRoll(player);
        games.add(diceRollGame3);
        DiceRoll diceRollGame4 = new DiceRoll(player);
        games.add(diceRollGame4);
        DiceRoll diceRollGame5 = new DiceRoll(player);
        games.add(diceRollGame5);
    }


    @DisplayName("Add game test")
    @Test
    void addGameTest() {
        DiceRollDTO diceRollDTO = diceRollService.addGame(player);
        games.add(diceRollService.dTOToDiceRoll(diceRollDTO, player));
        Mockito.when(diceRollRepository.findByPlayer(player))
                .thenReturn(games);
        diceRollService.getGames(player);
    }

    @DisplayName("Get games test")
    @Test
    void getGamesTest(){
        Mockito.when(diceRollRepository.findByPlayer(player))
                .thenReturn(games);
        List<DiceRollDTO> gamesExpectedDTO = diceRollService.getGames(player);
        List<DiceRoll> gamesExpected = new ArrayList<>();
        gamesExpectedDTO.forEach(l -> gamesExpected
                .add(diceRollService.dTOToDiceRoll(l, player)));
        Assertions.assertThat(games).hasSize(gamesExpected.size());
        assertTrue(new ReflectionEquals(games).matches(gamesExpected));
    }
    
    /*
    @DisplayName("Delete game test")
    @Test
    void deleteGamesTest(){

    }
    */
}
