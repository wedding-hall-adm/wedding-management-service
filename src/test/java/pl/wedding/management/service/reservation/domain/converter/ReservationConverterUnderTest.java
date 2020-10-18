package pl.wedding.management.service.reservation.domain.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationConverterUnderTest {

    ReservationConverter reservationConverter;
    ReservationDto reservationDto;

    @BeforeEach
    void setUp() {
        reservationConverter = new ReservationConverter();
        reservationDto = ReservationDto.builder()
                .id(1)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();
    }

    @Test
    void convertFromEntity_EqualObject_Equals() {
        //given
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .id(1)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();

        //when
        ReservationDto result = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertThat(result).isEqualTo(reservationDto);

    }

    @Test
    void convertFromEntity_SameIdObject_Equals() {
        //given
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .id(1)
                .reservationStart(LocalDateTime.of(2023,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2023,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(2003)
                .occasion(Occasion.CONFERENCE)
                .build();

        //when
        ReservationDto result = reservationConverter.convertFromEntity(reservationEntity);

        //then
        assertThat(result).isEqualTo(reservationDto);
    }

    @Test
    void convertFromEntity_DifferentIdObject_NotEquals() {
        //given
        ReservationEntity reservationEntityDifferId = ReservationEntity.builder()
                .id(2)
                .reservationStart(LocalDateTime.of(2020,Month.OCTOBER,3,18,30,0))
                .reservationEnd(LocalDateTime.of(2020,Month.OCTOBER,4,6,30,0))
                .numberOfGuests(200)
                .occasion(Occasion.DIVORCE_PARTY)
                .build();

        //when
        ReservationDto result =
                reservationConverter.convertFromEntity(reservationEntityDifferId);

        //then
        assertThat(result).isNotEqualTo(reservationDto);
    }

    @Test
    void convertFromEntity_NullValuesObject_NoNPE() {
        //given
        ReservationEntity reservationEntityNullValuesObject = ReservationEntity.builder().build();
        //when
        ReservationDto result = reservationConverter.convertFromEntity(reservationEntityNullValuesObject);
        //then
        assertThat(result).hasAllNullFieldsOrPropertiesExcept("id", "numberOfGuests");
        assertThat(result.getId()).isEqualTo(0);
        assertThat(result.getNumberOfGuests()).isEqualTo(0);
    }
}
