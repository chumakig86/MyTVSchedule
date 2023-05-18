package com.example.mytvschedule.repository;

import com.example.mytvschedule.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    List<Episode> findAllByTvShowId(int id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Episode e set e.watched = :watched where e.id = :id")
    void setWatchedById(int id, boolean watched);
}
