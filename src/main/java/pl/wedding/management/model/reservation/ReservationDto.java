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

    private final long id;
    private final LocalDateTime reservationStart;
    private final LocalDateTime reservationEnd;
    private final Object weddingHall; //to be changed
    private final Object tenant; //to be changed
    private final int numberOfGuests;
    private final Occasion occasion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDto that = (ReservationDto) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
