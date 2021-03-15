package iitu.kz.demo.service;

import iitu.kz.demo.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void create(User user);
    Page<User> getAll();
    List<User> getUsersByName(String name);
    User getById(Long id);
    void update(Long id, User user);
    void delete(Long id);
}
