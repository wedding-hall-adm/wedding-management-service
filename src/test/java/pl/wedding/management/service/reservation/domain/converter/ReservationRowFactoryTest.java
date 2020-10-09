package pl.wedding.management.service.reservation.domain.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRowFactoryTest {

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
    void convertFromDtoIsEqual() {
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
        ReservationEntity reservationEntityFromConverter = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertEquals(reservationEntity, reservationEntityFromConverter);
    }

    @Test
    void convertFromDtoCutSecondsIsEqual() {
        //given
        ReservationDto reservationDto = new ReservationDto(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,20,44),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,15,55),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationEntity reservationEntityFromConverter = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertEquals(reservationEntity, reservationEntityFromConverter);
    }

    @Test
    void convertFromDtoIsNotEqual() {
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

        ReservationDto reservationDtoDifferDate = new ReservationDto(
                1,
                LocalDateTime.of(2021,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2021,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        ReservationDto reservationDtoDifferGuests = new ReservationDto(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                201,
                Occasion.DIVORCE_PARTY
        );

        ReservationDto reservationDtoDifferOccasion = new ReservationDto(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.BACHELOR_PARTY
        );

        //when
        ReservationEntity reservationEntityFromConverterDifferId =
                reservationRowFactory.convertFromDto(reservationDtoDifferId);
        ReservationEntity reservationEntityFromConverterDifferDate =
                reservationRowFactory.convertFromDto(reservationDtoDifferDate);
        ReservationEntity reservationEntityFromConverterDifferGuests =
                reservationRowFactory.convertFromDto(reservationDtoDifferGuests);
        ReservationEntity reservationEntityFromConverterDifferOccasion =
                reservationRowFactory.convertFromDto(reservationDtoDifferOccasion);


        //then
        assertNotEquals(reservationEntity, reservationEntityFromConverterDifferId);
        assertNotEquals(reservationEntity, reservationEntityFromConverterDifferDate);
        assertNotEquals(reservationEntity, reservationEntityFromConverterDifferGuests);
        assertNotEquals(reservationEntity, reservationEntityFromConverterDifferOccasion);

    }
}