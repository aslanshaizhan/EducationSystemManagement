package iitu.kz.demo.events;

import iitu.kz.demo.entities.User;
import org.springframework.context.ApplicationEvent;

public class UserCreateEvent extends ApplicationEvent {

    private User user;

    public UserCreateEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
