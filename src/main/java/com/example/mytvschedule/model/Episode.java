package com.example.mytvschedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Episode {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "episode_name")
    private String name;
    @Column(name = "season_number")
    @JsonProperty("season")
    private int seasonNumber;
    @Column(name = "episode_number")
    @JsonProperty("number")
    private int episodeNumber;
    @Column(name = "air_date")
    @JsonProperty("airdate")
    private LocalDate airDate;
    @Column(name = "watched")
    private boolean watched;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tv_show_id")
    @EqualsAndHashCode.Exclude
    private TvShow tvShow;
}
