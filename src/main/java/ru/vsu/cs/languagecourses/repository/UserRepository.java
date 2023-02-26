package ru.vsu.cs.languagecourses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.languagecourses.entity.Users;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findAll();

}
