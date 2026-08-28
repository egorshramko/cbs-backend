package io.github.egorshramko.cbs.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import io.github.egorshramko.cbs.model.enums.MovieFormat;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hall {

    @Id
    @SequenceGenerator(
        name = "hall_pkey_generator", 
        sequenceName = "hall_pkey_seq",
        initialValue = 1,
        allocationSize = 1)
    @GeneratedValue(generator = "hall_pkey_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema", nullable = false)
    private Cinema cinema;

    @Column(name = "name_")
    private String name;

    @Builder.Default
    @ElementCollection(targetClass = MovieFormat.class)
    @CollectionTable(name = "hall_movie_format", joinColumns = @JoinColumn(name = "hall"))
    @Column(name = "movie_format")
    @Enumerated(EnumType.STRING)
    private Set<MovieFormat> movieFormats = new HashSet<>();

}
