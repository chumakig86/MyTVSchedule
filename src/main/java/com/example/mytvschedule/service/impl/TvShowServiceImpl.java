package com.example.mytvschedule.service.impl;

import com.example.mytvschedule.client.TvMazeClient;
import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.model.Person;
import com.example.mytvschedule.model.TvShow;
import com.example.mytvschedule.repository.TvShowRepository;
import com.example.mytvschedule.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TvShowServiceImpl implements TvShowService {
    @Autowired
    TvMazeClient tvMazeClient;
    @Autowired
    TvShowRepository tvShowRepository;

    @Override
    public TvShow addShow(int id) {
        TvShow show = tvMazeClient.getShowById(id);
        Set<Person> cast = tvMazeClient.getCastByShowId(id);
        cast.forEach(person -> person.setTvShow(Set.of(show)));
        show.setCast(cast);
        Set<Episode> episodes = tvMazeClient.getEpisodesByShowId(id);
        episodes.forEach(episode -> episode.setTvShow(show));
        show.setEpisodes(episodes);
        tvShowRepository.save(show);
        return show;
    }

    @Override
    @Transactional
    public void deleteShow(int id) {
        tvShowRepository.deleteById(id);
    }

    @Override
    public List<TvShow> listShows() {
        return tvShowRepository.findAll();
    }

    @Override
    public List<TvShow> listUnwatchedShows() {
        return tvShowRepository.findAllUnwatched();
    }


}
