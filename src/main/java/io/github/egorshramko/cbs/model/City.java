package io.github.egorshramko.cbs.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class City {
    
    @Id
    @SequenceGenerator(name = "city_pkey_generator", 
        sequenceName = "city_pkey_seq", 
        initialValue = 1, 
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_pkey_generator")
    private Long id;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    private Boolean actual;

    @Column(name = "name_")
    private String name;

}
