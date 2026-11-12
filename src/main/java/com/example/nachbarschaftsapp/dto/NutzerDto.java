package com.example.nachbarschaftsapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NutzerDto {
    private String vorname;
    private String nachname;
    private AdresseDto standort;
}
