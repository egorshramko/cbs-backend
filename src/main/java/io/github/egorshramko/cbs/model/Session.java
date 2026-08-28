package io.github.egorshramko.cbs.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "session_")
public class Session {

    @Id
    @SequenceGenerator(
        name = "session_pkey_generator", 
        sequenceName = "session_pkey_seq", 
        initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "session_pkey_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    private LocalDateTime sessionDatetime;
    
    private Boolean actual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie")
    @NonNull
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall")
    @NonNull
    private Hall hall;

}
