package io.github.egorshramko.cbs.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import io.github.egorshramko.cbs.model.enums.AgeLimit;
import io.github.egorshramko.cbs.model.enums.GenreCode;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_gen")
    @SequenceGenerator(name = "movie_id_gen", sequenceName = "movie_pkey_seq", 
            initialValue = 1, allocationSize = 1)
    private Long id;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @NonNull
    @Column(name = "name_")
    private String name;

    private Boolean actual;

    @Builder.Default
    @ElementCollection(targetClass = GenreCode.class)
    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie"))
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Set<GenreCode> genres = new HashSet<>();

    private Duration duration;

    private LocalDate releaseDate;

    private String country;

    private String posterFilename;

    @Enumerated(EnumType.STRING)
    private AgeLimit ageLimit;

}
