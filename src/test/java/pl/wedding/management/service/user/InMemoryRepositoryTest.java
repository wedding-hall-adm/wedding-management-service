package pl.wedding.management.service.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.user.model.EMail;
import pl.wedding.management.service.user.model.User;

import static org.assertj.core.api.Assertions.*;

class InMemoryRepositoryTest {

    private static final char[] DUMMY_PASSWORD = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    private final User constUser = createUser("someEmail@dummy.pl");

    private InMemoryRepository underTest;

    @BeforeEach
    void setUp() {
        underTest = new InMemoryRepository();
        underTest.clearInMemoryRepository();
    }

    @Test
    void addNewUser_whenUserDoesNotExists_thenNewUserAddedAndHaveId(){

        //When
        Integer result = underTest.addUser(constUser);

        //Then
        assertThat(result).isEqualTo(0);
        assertThat(underTest.countAllUsers()).isEqualTo(1);
        assertThat(underTest.getAllUsers()).containsOnly(constUser);
    }

    @Test
    public void addNewUser_whenUserAlreadyExists_thenShouldThrowException(){

        //Given
        underTest.addUser(constUser);

        //When
        assertThatThrownBy(() -> underTest.addUser(constUser)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void removeUser_whenUserExists_thenUserIsRemoved(){

        //Given
        underTest.addUser(constUser);

        //When
        underTest.removeUserById(0);

        //Then
        assertThat(underTest.findUserByEmail("someEmail@dummy.pl")).isEmpty();
        assertThat(underTest.countAllUsers()).isEqualTo(0);
    }

    //No more test added. Only temporary solution. I won't spent more time.

    private User createUser(String email) {

        return User.builder()
                .email(new EMail(email))
                .password(DUMMY_PASSWORD)
                .build();
    }
}