package com.example.mytvschedule.service;

import com.example.mytvschedule.model.Episode;
import org.springframework.stereotype.Component;

@Component
public interface EpisodeService {
    Episode getFirstUnwatchedByShowId(int id);
    void setWatched(int id, boolean watched);
}
