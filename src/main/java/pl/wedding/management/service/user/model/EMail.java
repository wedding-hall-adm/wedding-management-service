package pl.wedding.management.service.user.model;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
public class EMail {

    private static final String AT_SIGN = "@";
    private final String email;

    public EMail(String email) {

        if(isInvalid(email)){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    private boolean isInvalid(String value){

        //TODO: Email Validation
        if(StringUtils.isEmpty(value) || !value.contains(AT_SIGN)){
            //Current approach is just temporary
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EMail eMail = (EMail) o;
        return Objects.equals(email, eMail.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
