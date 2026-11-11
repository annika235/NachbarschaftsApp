package com.example.nachbarschaftsapp.services;

import com.example.nachbarschaftsapp.domain.Adresse;
import com.example.nachbarschaftsapp.domain.Nutzer;
import com.example.nachbarschaftsapp.entities.NutzerEntity;
import com.example.nachbarschaftsapp.mapper.NutzerMapper;
import com.example.nachbarschaftsapp.repositories.NutzerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NutzerService {
    private final NutzerRepository nutzerRepository;
    private final NutzerMapper nutzerMapper;

    public NutzerService(NutzerRepository nutzerRepository,NutzerMapper nutzerMapper) {
        this.nutzerRepository = nutzerRepository;
        this.nutzerMapper = nutzerMapper;
    }

    public Optional<Nutzer> zeigeNutzer(UUID id){
        return nutzerRepository.findById(id).map(nutzerMapper::toDomain);
    }
    public Nutzer bearbeiteNutzer(Nutzer nutzer,UUID uuid){
        NutzerEntity entity = nutzerMapper.toEntity(nutzer);
        entity.setUuid(uuid);
        NutzerEntity nutzerGespeichert = nutzerRepository.save(entity);
        return nutzerMapper.toDomain(nutzerGespeichert);
    }

    public Nutzer erstelleNutzer(Nutzer nutzer) {
        NutzerEntity nutzerEntity = nutzerRepository.save(nutzerMapper.toEntity(nutzer));
        return nutzerMapper.toDomain(nutzerEntity);
    }

    public void loescheNutzer(UUID uuid) {
        nutzerRepository.deleteById(uuid);
    }
}
