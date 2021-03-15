package iitu.kz.demo.entities;

import iitu.kz.demo.service.UserService;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;

@Entity
public class User implements UserService {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String generalStud;
    private String higherStud;

    @OneToMany
    private List<User> users;

    public User(Long id, String firstname, String lastname, String email, String generalStud, String higherStud, List<User> users, UserType userType) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.generalStud = generalStud;
        this.higherStud = higherStud;
        this.users = users;
        this.userType = userType;
    }

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeneralStud() {
        return generalStud;
    }

    public void setGeneralStud(String generalStud) {
        this.generalStud = generalStud;
    }

    public String getHigherStud() {
        return higherStud;
    }

    public void setHigherStud(String higherStud) {
        this.higherStud = higherStud;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public void create(User user) {
    }

    @Override
    public Page<User> getAll() {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public String toString() {
        return "Current User{" +
                "id=" + id +
                ", name=" + firstname + ", email="+ email +
                '}';
    }
}
