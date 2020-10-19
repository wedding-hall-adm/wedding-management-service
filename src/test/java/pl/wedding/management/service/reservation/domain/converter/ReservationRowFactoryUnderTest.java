package pl.wedding.management.service.reservation.domain.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationRowFactoryUnderTest {

    ReservationRowFactory reservationRowFactory;
    ReservationEntity reservationEntity;

    @BeforeEach
    void setUp() {
        reservationRowFactory = new ReservationRowFactory();
        reservationEntity = ReservationEntity.builder()
                .id(1L)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();
    }

    @Test
    void convertFromDto_EqualObject_Equals() {
        //given
        ReservationDto reservationDto = ReservationDto.builder()
                .id(1L)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();

        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertThat(result).isEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_EqualObjectWithSeconds_Equals() {
        //given
        ReservationDto reservationDto = ReservationDto.builder()
                .id(1L)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,30,333))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,30,333))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();

        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertThat(result).isEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_SameIdObject_Equals() {
        //given
        ReservationDto reservationDto = ReservationDto.builder()
                .id(1L)
                .reservationStart(LocalDateTime.of(2022,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2022,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(2002)
                .occasion(Occasion.FUNERAL)
                .build();

        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDto);

        //then
        assertThat(result).isEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_DifferentObjectId_NotEquals() {
        //given
        ReservationDto reservationDtoDifferId = ReservationDto.builder()
                .id(2L)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();

        //when
        ReservationEntity result =
                reservationRowFactory.convertFromDto(reservationDtoDifferId);

        //then
        assertThat(result).isNotEqualTo(reservationEntity);
    }

    @Test
    void convertFromDto_NullValuesObject_noNPE() {
        //given
        ReservationDto reservationDtoNullValuesObject = ReservationDto.builder().build();
        //when
        ReservationEntity result = reservationRowFactory.convertFromDto(reservationDtoNullValuesObject);
        //then
        assertThat(result).hasAllNullFieldsOrProperties();
    }
}
