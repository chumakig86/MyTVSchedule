package com.example.mytvschedule.contoller;

import com.example.mytvschedule.model.TvShow;
import com.example.mytvschedule.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class TvScheduleController {
    @Autowired
    private TvShowService tvShowService;

    @PostMapping("/{id}")
    public ResponseEntity addShow(@PathVariable int id) {
        return new ResponseEntity(tvShowService.addShow(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeShow(@PathVariable int id) {
        tvShowService.deleteShow(id);
        return new ResponseEntity("Successfully deleted tv show with id " + id, HttpStatus.OK);
    }

    @GetMapping("/getShows")
    public List<TvShow> getShows() {
        return tvShowService.listShows();
    }

    @GetMapping("/getUnwatchedShows")
    public List<TvShow> getUnwatchedShows() {
        return tvShowService.listUnwatchedShows();
    }
}
