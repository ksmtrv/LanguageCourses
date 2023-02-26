package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Intensity;

import java.util.List;

@Repository
public interface IntensityRepository extends CrudRepository<Intensity, Long> {
    List<Intensity> findAll();
}
