package pl.wedding.management.service.reservation.domain.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReservationConverterUnderTest {

    ReservationConverter reservationConverter;
    ReservationDto reservationDto;

    @BeforeEach
    void setUp() {
        reservationConverter = new ReservationConverter();
        reservationDto = new ReservationDto(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );
    }

    @Test
    void convertFromEntity_EqualObject_Equals() {
        //given
        ReservationEntity reservationEntity = new ReservationEntity(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationDto result = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertThat(result).isEqualTo(reservationDto);

    }

    @Test
    void convertFromEntity_SameIdObject_Equals() {
        //given
        ReservationEntity reservationEntity = new ReservationEntity(
                1,
                LocalDateTime.of(2021,Month.OCTOBER,13,18,30,20,20),
                LocalDateTime.of(2021,Month.OCTOBER,14,6,30,20),
                new Object(),
                new Object(),
                2000,
                Occasion.FUNERAL
        );

        //when
        ReservationDto result = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertThat(result).isEqualTo(reservationDto);
    }

    @Test
    void convertFromEntity_DifferentIdObject_NotEquals() {
        //given
        ReservationEntity reservationEntityDifferId = new ReservationEntity(
                2,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationDto result =
                reservationConverter.convertFromEntity(reservationEntityDifferId);

        //then
        assertThat(result).isNotEqualTo(reservationDto);
    }
}