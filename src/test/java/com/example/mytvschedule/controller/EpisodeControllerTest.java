package com.example.mytvschedule.controller;

import com.example.mytvschedule.contoller.EpisodeController;
import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.service.EpisodeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EpisodeController.class)
public class EpisodeControllerTest {
    private static final int TEST_ID = 1;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EpisodeService service;

    static Episode teststEpisode;

    @BeforeAll
    static void setUp() {
        teststEpisode = new Episode();
        teststEpisode.setId(TEST_ID);
    }

    @Test
    public void getUnwatchedEpisodesShouldReturnListFromService() throws Exception {
        when(service.getFirstUnwatchedByShowId(TEST_ID)).thenReturn(teststEpisode);
        this.mockMvc.perform(get("/episodes/unwatchedEpisode/" + TEST_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(TEST_ID))));
    }

    @Test
    public void setWatchedEpisodesShouldSetWatched() throws Exception {
        this.mockMvc.perform(put("/episodes/setWatched/" + TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(true)))
                        .andExpect(status().isOk())
                        .andExpect(content().string(containsString("Success")));
    }
}
