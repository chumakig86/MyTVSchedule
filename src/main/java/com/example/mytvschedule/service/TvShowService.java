package com.example.mytvschedule.service;

import com.example.mytvschedule.model.TvShow;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TvShowService {
    TvShow addShow(int id);
    void deleteShow(int id);
    List<TvShow> listShows();

    List<TvShow> listUnwatchedShows();
}
