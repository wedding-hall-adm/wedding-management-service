package pl.wedding.management.model.reservation;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
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
