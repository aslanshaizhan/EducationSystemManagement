package iitu.kz.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler implements ApplicationListener<UserCreateEvent> {

    @Override
    public void onApplicationEvent(UserCreateEvent userCreateEvent) {
        System.out.println("UserCreateHandler.onApplicationEvent");
        System.out.println("Created user info: " + userCreateEvent.getUser());
    }
}
