package pl.wedding.management.service.user.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
public class User {

    private final Integer userId;
    private final EMail email;
    private final char[] password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
