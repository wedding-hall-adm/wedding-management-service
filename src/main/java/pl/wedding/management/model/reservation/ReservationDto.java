package pl.wedding.management.model.reservation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ReservationDto {

    public final long id;

    public final LocalDateTime reservationStart;
    public final LocalDateTime reservationEnd;

    public final Object weddingHall; //to be changed
    public final Object tenant; //to be changed

    public int numberOfGuests;

    public final Occasion occasion;

}
