package com.example.mytvschedule.client;

import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.model.Person;
import com.example.mytvschedule.model.TvShow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TvMazeClientTest {
    public static final int TEST_ID = 1;
    @Autowired
    TvMazeClient tvMazeClient;

    @Test
    public void getShowByIdShouldReturnShow() {
        TvShow testShow = tvMazeClient.getShowById(TEST_ID);
        assertNotNull(testShow);
        assertEquals(TEST_ID, testShow.getId());
    }

    @Test
    public void getCastByShowIdShouldReturnCast() {
        Set<Person> cast = tvMazeClient.getCastByShowId(TEST_ID);
        assertNotNull(cast);
        int expectedSize = 15;
        assertEquals(expectedSize, cast.size());
    }

    @Test
    public void getEpisodesByShowIdShouldReturnEpisodes() {
        Set<Episode> episodes = tvMazeClient.getEpisodesByShowId(TEST_ID);
        assertNotNull(episodes);
        int expectedSize = 39;
        assertEquals(expectedSize, episodes.size());
    }
}
