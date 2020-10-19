package pl.wedding.management.service.user;

import pl.wedding.management.service.user.model.User;

import java.util.*;
import java.util.function.Function;

final class InMemoryRepository implements UserRepository {

    private static final Set<User> MEMORY_USER_REPOSITORY = new HashSet<>();

    @Override
    public Optional<User> findUserById(Integer id) {

        return findByObjectValue(id, User::getUserId);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {

        return findByObjectValue(email, User::getEmail);
    }

    @Override
    public Integer addUser(User user) {

        if(MEMORY_USER_REPOSITORY.contains(user)){
            throw new IllegalStateException("User already exists!");
        }

        User userWithId = User.builder()
                .userId(getLastIndexOfRepository())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        MEMORY_USER_REPOSITORY.add(userWithId);

        return userWithId.getUserId();
    }

    @Override
    public boolean removeUserById(Integer id) {

        Optional<User> user = findByObjectValue(id, User::getUserId);
        return user.map(MEMORY_USER_REPOSITORY::remove)
                .orElse(false);
    }

    @Override
    public Collection<User> getAllUsers() {
        return MEMORY_USER_REPOSITORY;
    }

    @Override
    public int countAllUsers() {
        return MEMORY_USER_REPOSITORY.size();
    }

    /** ONLY FOR TESTING PURPOSES ! */
    void clearInMemoryRepository(){

        MEMORY_USER_REPOSITORY.clear();
    }

    private Optional<User> findByObjectValue(Object value, Function<User, ?> getter){

        return MEMORY_USER_REPOSITORY.stream()
                .filter(user ->  Objects.equals(value, getter.apply(user)))
                .findAny();
    }

    private int getLastIndexOfRepository(){

        return MEMORY_USER_REPOSITORY.size();
    }
}
