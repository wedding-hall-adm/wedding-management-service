package pl.wedding.management.service.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import java.time.LocalDateTime;

@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ReservationDto {

    public final Long id;
    public final LocalDateTime reservationStart;
    public final LocalDateTime reservationEnd;
    public final Object weddingHall; //to be changed
    public final Object tenant; //to be changed
    public Integer numberOfGuests;
    public final Occasion occasion;
}
