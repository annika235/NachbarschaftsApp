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
@Table(name="adresse")
public class AdresseEntity {

    //TODO [Reverse Engineering] generate columns from DB
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "koordinaten_id")
    private KoordinatenEntity koordinaten;
}