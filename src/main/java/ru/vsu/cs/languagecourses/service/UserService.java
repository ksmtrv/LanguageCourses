package ru.vsu.cs.languagecourses.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.languagecourses.dto.UsersDto;
import ru.vsu.cs.languagecourses.entity.Users;
import ru.vsu.cs.languagecourses.mapper.UsersMapper;
import ru.vsu.cs.languagecourses.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UsersMapper mapper;

    public UserService(UserRepository repository, UsersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UsersDto> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    public void saveNewUser(Users users) {
        repository.save(users);
    }

    private Users findById(Long id) {
        return repository.findAll().stream()
                .filter(val->val.getId().equals(id)).toList().get(0);
    }

    public void updateUser(Long id, Users users) {
        Users oldUsers = findById(id);
        oldUsers.setName(users.getName());
        oldUsers.setAge(users.getAge());
        repository.save(oldUsers);
    }
}
