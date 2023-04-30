package ru.vsu.cs.languagecourses.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.languagecourses.dto.LanguageDto;
import ru.vsu.cs.languagecourses.entity.Language;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageDto toDto(Language language);
    Language toEntity(LanguageDto dto);
}