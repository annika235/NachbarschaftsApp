package com.example.nachbarschaftsapp.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Beitrag {
    private UUID uuid;
    private String titel;
    private String beschreibung;
    private Adresse standort;
    private Nutzer nutzer;

    private List<String> bilder;
    //private List<Chats> chats;

}
