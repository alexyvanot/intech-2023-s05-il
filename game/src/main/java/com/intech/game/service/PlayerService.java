package com.intech.game.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intech.game.model.Player;
import com.intech.game.repository.PlayerRepository;

@Service
public class PlayerService {

	private PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
	public Optional<Player> getPlayer(Integer id) {
		return playerRepository.findById(id);
	}

}