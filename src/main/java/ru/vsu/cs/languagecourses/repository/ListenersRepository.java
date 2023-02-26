package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Listeners;

import java.util.List;

@Repository
public interface ListenersRepository extends CrudRepository<Listeners, Long> {
    List<Listeners> findAll();
}
