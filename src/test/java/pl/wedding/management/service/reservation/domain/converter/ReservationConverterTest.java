package pl.wedding.management.service.reservation.domain.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ReservationConverterTest {

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
    void convertFromEntityIsEqual() {

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
        ReservationDto reservationDtoFromConverter = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertEquals(reservationDto, reservationDtoFromConverter);
    }

    @Test
    void convertFromEntityCutSecondsIsEqual() {

        //given
        ReservationEntity reservationEntity = new ReservationEntity(
                1,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,20,20),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,20),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        //when
        ReservationDto reservationDtoFromConverter = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertEquals(reservationDto, reservationDtoFromConverter);
    }

    @Test
    void convertFromEntityIsNotEqual() {
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

        ReservationEntity reservationEntityDifferDate = new ReservationEntity(
                2,
                LocalDateTime.of(2021,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2021,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.DIVORCE_PARTY
        );

        ReservationEntity reservationEntityDifferGuests = new ReservationEntity(
                2,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                201,
                Occasion.DIVORCE_PARTY
        );
        ReservationEntity reservationEntityDifferOccasion = new ReservationEntity(
                2,
                LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0),
                LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0),
                new Object(),
                new Object(),
                200,
                Occasion.FUNERAL
        );

        //when
        ReservationDto reservationDtoFromConverterDifferId =
                reservationConverter.convertFromEntity(reservationEntityDifferId);
        ReservationDto reservationDtoFromConverterDifferDate =
                reservationConverter.convertFromEntity(reservationEntityDifferDate);
        ReservationDto reservationDtoFromConverterDifferGuests =
                reservationConverter.convertFromEntity(reservationEntityDifferGuests);
        ReservationDto reservationDtoFromConverterDifferOccasion =
                reservationConverter.convertFromEntity(reservationEntityDifferOccasion);


        //then
        assertNotEquals(reservationDto, reservationDtoFromConverterDifferId);
        assertNotEquals(reservationDto, reservationDtoFromConverterDifferDate);
        assertNotEquals(reservationDto, reservationDtoFromConverterDifferGuests);
        assertNotEquals(reservationDto, reservationDtoFromConverterDifferOccasion);
    }
}