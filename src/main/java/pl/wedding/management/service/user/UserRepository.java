package pl.wedding.management.service.user;

import pl.wedding.management.service.user.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findUserById(Integer id);

    Optional<User> findUserByEmail(String email);

    /** @return ID of added user */
    Integer addUser(User user);

    /** @return If user has been removed. */
    boolean removeUserById(Integer id);

    Collection<User> getAllUsers();

    int countAllUsers();
}
