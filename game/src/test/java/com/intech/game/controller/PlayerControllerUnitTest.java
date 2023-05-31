package com.intech.game.controller;

import com.intech.game.model.Player;
import com.intech.game.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PlayerControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @WithMockUser
    @Test
    public void testGetPlayers() throws Exception {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setPlayerId(1);
        player1.setUsername("test1");
        player1.setLevel(100);
        players.add(player1);

        Mockito.when(playerService.getPlayers()).thenReturn(players);

        RequestBuilder rb = MockMvcRequestBuilders.get("/player");

        ResultActions ra = mockMvc.perform(rb);

        ra.andExpect(MockMvcResultMatchers.status().isOk());
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].playerId").value(1));
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("test1"));
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].level").value(100));

    }

    @WithMockUser
    @Test
    public void testGetPlayerNotFound() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/player/1");
        ResultActions ra = mockMvc.perform(rb);
        ra.andDo(MockMvcResultHandlers.print());
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
