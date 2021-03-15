package iitu.kz.demo.service.impl;

import iitu.kz.demo.entities.User;
import iitu.kz.demo.repository.UserRepository;
import iitu.kz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> getAll() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name"));
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> getUsersByName(String name) {
        userRepository.findByNameAndAgeGreaterThanEqual(name, 4);
        return userRepository.findByNameGreaterThan(name, 10);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();
            dbUser.setFirstname(user.getFirstname());
            userRepository.save(dbUser);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
