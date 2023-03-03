package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Level;

import java.util.List;

@Repository
public interface LevelRepository extends CrudRepository<Level, Long> {
    List<Level> findAll();
}
