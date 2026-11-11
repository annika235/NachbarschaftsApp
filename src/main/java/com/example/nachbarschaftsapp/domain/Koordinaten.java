package com.example.nachbarschaftsapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Koordinaten {
    private UUID uuid;
    private double laengengrad;
    private double breitengrad;
}
