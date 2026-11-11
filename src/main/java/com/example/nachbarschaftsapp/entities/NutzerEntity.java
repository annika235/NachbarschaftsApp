package com.example.nachbarschaftsapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name="nutzer")
public class NutzerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String vorname;
    private String nachname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="standort_id")
    private AdresseEntity standort;
    @OneToMany(mappedBy = "nutzer")
    private List<BeitragEntity> beitraege;
}
