package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repository;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByName(String name);
}
