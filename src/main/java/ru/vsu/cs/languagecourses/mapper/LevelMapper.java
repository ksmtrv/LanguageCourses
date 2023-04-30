package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.LevelDto;
import ru.vsu.cs.languagecourses.entity.Level;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelDto toDto(Level level);
    Level toEntity(LevelDto dto);
}