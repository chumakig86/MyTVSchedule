package com.example.mytvschedule.repository;

import com.example.mytvschedule.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Integer> {
    @Query("select e.tvShow from Episode e where e.watched = false")
    List<TvShow> findAllUnwatched();
}
