package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.ListenerDto;
import ru.vsu.cs.languagecourses.entity.Listener;

@Mapper(componentModel = "spring")
public interface ListenerMapper {
    ListenerDto toDto(Listener listener);
    Listener toEntity(ListenerDto dto);
}
