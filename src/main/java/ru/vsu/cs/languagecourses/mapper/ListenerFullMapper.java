package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.listener.ListenerFullDto;
import ru.vsu.cs.languagecourses.entity.Listener;

@Mapper(componentModel = "spring")
public interface ListenerFullMapper {
    ListenerFullDto toDto(Listener listener);
    Listener toEntity(ListenerFullDto dto);
}
