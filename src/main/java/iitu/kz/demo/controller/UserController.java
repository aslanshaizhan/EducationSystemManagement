package iitu.kz.demo.controller;

import iitu.kz.demo.entities.User;
import iitu.kz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public Page<User> getAll() {
        return userService.getAll();
    }

    public List<User> getUserByName(String name) {
        return userService.getUsersByName(name);
    }
}
