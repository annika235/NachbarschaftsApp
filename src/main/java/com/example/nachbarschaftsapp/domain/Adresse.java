package com.example.nachbarschaftsapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Adresse {
    private UUID uuid;
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private Koordinaten koordinaten;
}