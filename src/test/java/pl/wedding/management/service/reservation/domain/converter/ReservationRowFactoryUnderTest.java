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

class ReservationRowFactoryUnderTest {

    ReservationRowFactory reservationRowFactory;
    ReservationEntity reservationEntity;

    @BeforeEach
    void setUp() {
        reservationRowFactory = new ReservationRowFactory();
        reservationEntity = new ReservationEntity(
                1,
                LocalDateTime.of(2020, Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );
    }

    @Test
    void convertFromDto_EqualObject_Equals() {
        //given
        ReservationDto reservationDto = new ReservationDto(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertThat(result).isEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_SameIdObject_Equals() {
        //given
        ReservationDto reservationDto = new ReservationDto(
                1,
                LocalDateTime.of(2021,Month.OCTOBER,3,18,30,20,44),
                LocalDateTime.of(2021,Month.OCTOBER,14,6,30,15,55),
                new Object(),
                new Object(),
                2000,
                Occasion.FUNERAL
        );

        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertThat(result).isEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_DifferentObjectId_NotEquals() {
        //given
        ReservationDto reservationDtoDifferId = new ReservationDto(
                2,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationEntity result =
                reservationRowFactory.convertFromDto(reservationDtoDifferId);

        //then
        assertThat(result).isNotEqualTo(reservationEntity);
    }
}