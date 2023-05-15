package com.intech.game.controller;

import com.intech.game.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PlayerControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Timeout(unit = TimeUnit.MINUTES, value = 1)
    public void testGetPlayers() {

        Player[] players = restTemplate.getForObject("/player", Player[].class);

        assertEquals(1, players[0].getPlayerId());
        assertEquals("test1", players[0].getUsername());
        assertEquals(10, players[0].getLevel());

        assertEquals(2, players[1].getPlayerId());
        assertEquals("test2", players[1].getUsername());
        assertEquals(4, players[1].getLevel());

    }

    @Test
    @Timeout(unit = TimeUnit.MINUTES, value = 1)
    public void testGetPlayer() {

        Player player = restTemplate.getForObject("/player/1", Player.class);

        assertEquals(1, player.getPlayerId());
        assertEquals("test1", player.getUsername());
        assertEquals(10, player.getLevel());
        assertEquals(2, player.getRewards().size());

    }
}
