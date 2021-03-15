package iitu.kz.demo.dao;

import iitu.kz.demo.entities.User;
import iitu.kz.demo.events.UserCreateEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher eventPublisher;

    public void create(User user) {
        System.out.println("UserDao.create");
        System.out.println("user = " + user);

        this.eventPublisher.publishEvent(new UserCreateEvent(this, user));
    }

    public void update(Long id, User user) {
        System.out.println("UserDao.update");
    }

    public void delete(Long id) {
        System.out.println("UserDao.delete id: " + id);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
