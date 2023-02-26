package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.ListenersDto;
import ru.vsu.cs.languagecourses.entity.Listeners;

@Mapper(componentModel = "spring")
public interface ListenersMapper {
    ListenersDto toDto(Listeners listeners);
    Listeners toEntity(ListenersDto dto);
}
