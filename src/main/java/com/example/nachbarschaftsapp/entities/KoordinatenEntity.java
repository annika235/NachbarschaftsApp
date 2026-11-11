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
@Table(name="koordinaten")
public class KoordinatenEntity {

    //TODO [Reverse Engineering] generate columns from DB
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private double laengengrad;
    private double breitengrad;
}