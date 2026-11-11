package com.example.nachbarschaftsapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="beitrag")
public class BeitragEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String titel;
    private String beschreibung;
    @OneToOne
    @JoinColumn(name="standort_id")
    private AdresseEntity standort;

    @ManyToOne
    @JoinColumn(name="nutzer_id")
    private NutzerEntity nutzer;
}
