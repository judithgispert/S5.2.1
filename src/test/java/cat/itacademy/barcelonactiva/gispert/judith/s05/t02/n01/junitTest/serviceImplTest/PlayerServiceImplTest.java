package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.junitTest.serviceImplTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository.IPlayerRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IDiceRollService;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IPlayerService;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl.DiceRollServiceImpl;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl.PlayerServiceImpl;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {
    @Mock
    private IDiceRollService diceRollService;
    @Mock
    private IPlayerRepository playerRepository;

    @InjectMocks
    private IPlayerService playerService = new PlayerServiceImpl(playerRepository, diceRollService);

    private Player player;
    private Player playerAnonymous;
    private List<Player> players = new ArrayList<>();
    private List<DiceRollDTO> gamesDTO = new ArrayList<>();
    @BeforeEach
    void setUp() {
        player = new Player("Judith");
        player.setIdPlayer(1);
        players.add(player);

        playerAnonymous = new Player();
        playerAnonymous.setIdPlayer(2);
        players.add(playerAnonymous);
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        gamesDTO.add(diceRollDTO);
    }

    @DisplayName("Add player test")
    @Test
    void addPlayerTest(){
        Player player2 = new Player("Ariadna");
        players.add(player2);
        Mockito.when(playerRepository.findAll()).thenReturn(players);
        playerService.addPlayer(playerService.playerToPlayerDTO(player2));
        List<Player> playersExpected = playerService.getPlayers();
        assertTrue(new ReflectionEquals(players).matches(playersExpected));
    }

    @DisplayName("Get player by id test")
    @Test
    void getPlayerByIdTest(){
        Mockito.when(playerRepository.findById(1))
                .thenReturn(Optional.of(player));
        Player playerExpected = playerService.playerDTOToPlayer
                (playerService.getPlayerById(1));
        assertEquals(player.getIdPlayer(), playerExpected.getIdPlayer());
        assertEquals(player.getName(), playerExpected.getName());
        assertEquals(player.getGames().size(), playerExpected.getGames().size());
        assertEquals(player.getGamesWon(), playerExpected.getGamesWon());
        assertEquals(player.getGamesLost(), playerExpected.getGamesLost());
        verify(playerRepository).findById(1);
    }

    @DisplayName("Get players test")
    @Test
    void getPlayersTest(){
        Mockito.when(playerRepository.findAll())
                .thenReturn(Arrays.asList(player, playerAnonymous));
        List<Player> playersList = playerService.getPlayers();
        assertEquals(2, playersList.size());
        verify(playerRepository).findAll();
    }

    @DisplayName("Update player test")
    @Test
    void updatePlayerTest(){
        Mockito.when(playerRepository.findById(1))
                .thenReturn(Optional.of(player));
        PlayerDTO playerDTO = new PlayerDTO("Marga");
        playerService.updatePlayer(playerDTO, 1);
        assertEquals(player.getName(), "Marga");
    }

    @DisplayName("Add game/play test")
    @Test
    void playGameTest(){
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        gamesDTO.add(diceRollDTO);
        Mockito.when(playerRepository.findById(2)).thenReturn
                (Optional.of(playerAnonymous));
        Mockito.when(diceRollService.addGame(playerAnonymous))
                .thenReturn(diceRollDTO);
        DiceRollDTO diceRollDTOExpected = playerService.play(2);
        assertTrue(new ReflectionEquals(diceRollDTO)
                .matches(diceRollDTOExpected));
        }

    @DisplayName("Delete games test")
    @Test
    void deleteGamesTest(){
        Mockito.when(playerRepository.findById(2))
                .thenReturn(Optional.of(playerAnonymous));
        playerService.deleteGames(2);
        verify(diceRollService).deleteGames(playerAnonymous);
    }

    //@DisplayName("Restart percentage test")
    //@Test

    //@DisplayName("Update results test")
    //@Test

    //@DisplayName("Get ranking test")
    //@Test

    //@DisplayName("Get percentage ranking test")
    //@Test

    //@DisplayName("Get loser test")
    //@Test

    //@DisplayName("Get winner test")
    //@Test

}
