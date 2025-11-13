package io.github.eduardopec.libraryapi.controller.mappers;

import io.github.eduardopec.libraryapi.controller.dto.AutorDTO;
import io.github.eduardopec.libraryapi.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorDTO dto);
    AutorDTO toDTO(Autor autor);
}
