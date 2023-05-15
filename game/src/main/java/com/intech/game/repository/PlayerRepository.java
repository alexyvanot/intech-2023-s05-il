package com.intech.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intech.game.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
