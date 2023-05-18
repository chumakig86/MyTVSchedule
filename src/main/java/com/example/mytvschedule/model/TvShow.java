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
public class TvShow {
    @Id
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "show_name")
    private String name;
    @Column(name = "show_image")
    private String imageURL;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tvShow", cascade = CascadeType.ALL)
    private Set<Person> cast;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tvShow", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Episode> episodes;

    @JsonProperty("image")
    private void getImageUrl(Map<String, String> image) {
        if(image != null) imageURL = image.get("medium");
    }
}
