package com.example.mytvschedule.service.impl;

import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.repository.EpisodeRepository;
import com.example.mytvschedule.service.EpisodeService;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;
    @Override
    public Episode getFirstUnwatchedByShowId(int id) {
        List<Episode> episodes = episodeRepository.findAllByTvShowId(id);
        return episodes.stream().sorted(Comparator.comparingInt(Episode::getId))
                .filter(episode -> BooleanUtils.isFalse(episode.isWatched())).findFirst()
                .orElse(null);
    }

    @Override
    @Transactional
    public void setWatched(int id, boolean watched) {
        episodeRepository.setWatchedById(id, watched);
    }
}
