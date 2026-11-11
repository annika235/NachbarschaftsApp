package com.example.nachbarschaftsapp.mapper;

import com.example.nachbarschaftsapp.domain.Nutzer;
import com.example.nachbarschaftsapp.entities.NutzerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface NutzerMapper {
    NutzerMapper INSTANCE = Mappers.getMapper(NutzerMapper.class);

    Nutzer toDomain(NutzerEntity entity);

    NutzerEntity toEntity(Nutzer domain);
}
