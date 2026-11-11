package com.example.nachbarschaftsapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Nutzer {
    private String vorname;
    private String nachname;
    private Adresse standort;
    private List<Beitrag> beitraege = new ArrayList<>();

}
