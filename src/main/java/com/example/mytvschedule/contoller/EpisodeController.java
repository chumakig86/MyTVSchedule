package com.example.mytvschedule.contoller;

import com.example.mytvschedule.model.Episode;
import com.example.mytvschedule.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/unwatchedEpisode/{id}")
    public Episode getUnwatched(@PathVariable int id) {
        return episodeService.getFirstUnwatchedByShowId(id);
    }

    @PutMapping("/setWatched/{id}")
    public ResponseEntity setWatched(@PathVariable int id, @RequestBody boolean watched) {
        episodeService.setWatched(id, watched);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
