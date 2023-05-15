package com.intech.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intech.game.model.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

}
