package com.example.nachbarschaftsapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdresseDto {
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
}
