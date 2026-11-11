package com.example.nachbarschaftsapp.repositories;

import com.example.nachbarschaftsapp.entities.NutzerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NutzerRepository extends JpaRepository<NutzerEntity, UUID> {

}
