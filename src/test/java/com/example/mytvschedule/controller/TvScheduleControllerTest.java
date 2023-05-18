package com.example.mytvschedule.controller;

import com.example.mytvschedule.contoller.TvScheduleController;
import com.example.mytvschedule.model.TvShow;
import com.example.mytvschedule.service.TvShowService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TvScheduleController.class)
public class TvScheduleControllerTest {
    private static final int TEST_ID = 1;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TvShowService service;

    static TvShow testShow;

    @BeforeAll
    static void setUp() {
        testShow = new TvShow();
        testShow.setId(TEST_ID);
    }

    @Test
    public void addShowShouldReturnShowFromService() throws Exception {
        when(service.addShow(TEST_ID)).thenReturn(testShow);
        this.mockMvc.perform(post("/shows/" + TEST_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(String.valueOf(TEST_ID))));
    }

    @Test
    public void removeShowShouldRemoveShow() throws Exception {
        this.mockMvc.perform(delete("/shows/" + TEST_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(TEST_ID))));
    }

    @Test
    public void getShowsShouldReturnListFromService() throws Exception {
        when(service.listShows()).thenReturn(List.of(testShow));
        this.mockMvc.perform(get("/shows/getShows"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(TEST_ID))));
    }

    @Test
    public void getUnwatchedShowsShouldReturnListFromService() throws Exception {
        when(service.listUnwatchedShows()).thenReturn(List.of(testShow));
        this.mockMvc.perform(get("/shows/getUnwatchedShows"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(TEST_ID))));
    }
}
