package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Listener;

import java.util.List;

@Repository
public interface ListenerRepository extends CrudRepository<Listener, Long> {
    List<Listener> findAll();
}
