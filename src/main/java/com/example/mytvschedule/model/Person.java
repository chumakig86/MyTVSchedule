package com.example.mytvschedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cast")
public class Person {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "actor_name")
    private String name;
    @Column(name = "actor_image")
    private String imageURL;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<TvShow> tvShow;

    @JsonProperty("image")
    private void getImageUrl(Map<String, String> image) {
        if(image != null) imageURL = image.get("medium");
    }
}
