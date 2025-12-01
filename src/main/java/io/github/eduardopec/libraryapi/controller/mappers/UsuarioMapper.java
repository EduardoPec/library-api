package io.github.eduardopec.libraryapi.controller.mappers;

import io.github.eduardopec.libraryapi.controller.dto.UsuarioDTO;
import io.github.eduardopec.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
