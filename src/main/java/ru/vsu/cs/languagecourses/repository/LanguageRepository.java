package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Language;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();

    Optional<Language> findById(Long id);
}