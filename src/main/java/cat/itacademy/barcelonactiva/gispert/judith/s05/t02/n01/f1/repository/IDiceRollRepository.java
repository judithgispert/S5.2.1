package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repository;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiceRollRepository extends JpaRepository<DiceRoll, Integer> {

}
