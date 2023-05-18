package com.example.mytvschedule.client;

import com.example.mytvschedule.model.Cast;
import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.model.Person;
import com.example.mytvschedule.model.TvShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TvMazeClient {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${shows.path}")
    private String showApiUrl;
    @Value("${people.path}")
    private String peopleApiUrl;

    public TvShow getShowById(int id) {
        return restTemplate.getForObject(showApiUrl + id, TvShow.class);
    }

    public Set<Person> getCastByShowId(int showId) {
        ResponseEntity<List<Cast>> castResponse =
                restTemplate.exchange(showApiUrl + showId + "/cast",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });

        return castResponse.getBody().stream().map(Cast::getPerson).collect(Collectors.toSet());
    }

    public Set<Episode> getEpisodesByShowId(int showId) {
        ResponseEntity<Set<Episode>> episodesResponse =
                restTemplate.exchange(showApiUrl + showId + "/episodes",
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return episodesResponse.getBody();
    }
}
