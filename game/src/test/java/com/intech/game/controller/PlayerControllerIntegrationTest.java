package com.intech.game.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PlayerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPlayers() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/player");
        ResultActions ra = mockMvc.perform(rb);
        ra.andDo(MockMvcResultHandlers.print());
        // is ok
        ra.andExpect(MockMvcResultMatchers.status().isOk());
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].playerId").value(1));
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("test1"));
        ra.andExpect(MockMvcResultMatchers.jsonPath("$[0].level").value(10));
    }

}
