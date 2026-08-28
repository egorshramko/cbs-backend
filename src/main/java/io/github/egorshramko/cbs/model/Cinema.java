package io.github.egorshramko.cbs.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "cinema", uniqueConstraints = {
    @UniqueConstraint(name = "city_address_unique", columnNames = {"city", "address"})
})
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    @SequenceGenerator(name = "cinema_pkey_generator", 
        sequenceName = "cinema_pkey_seq", 
        initialValue = 1, allocationSize = 1)
    private Long id;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    private Boolean actual;

    @Column(name = "name_")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city", nullable = false)
    private City city;

    @Column(name = "address_")
    private String address;

    private Boolean hasParking;

    private String photoFilename;

    @OneToMany(
        mappedBy = "cinema", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true)
    private List<Hall> halls;

}
