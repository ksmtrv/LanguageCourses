package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.IntensityDto;
import ru.vsu.cs.languagecourses.entity.Intensity;

@Mapper(componentModel = "spring")
public interface IntensityMapper {
    IntensityDto toDto(Intensity intensity);
    Intensity toEntity(IntensityDto dto);
}