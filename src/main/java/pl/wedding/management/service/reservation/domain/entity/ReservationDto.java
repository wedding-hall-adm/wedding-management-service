package pl.wedding.management.service.reservation.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDto that = (ReservationDto) o;

        if (getId() != that.getId()) return false;
        if (getNumberOfGuests() != that.getNumberOfGuests()) return false;
        if (!getReservationStart().equals(that.getReservationStart())) return false;
        if (!getReservationEnd().equals(that.getReservationEnd())) return false;
        return getOccasion() == that.getOccasion();
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getReservationStart().hashCode();
        result = 31 * result + getReservationEnd().hashCode();
        result = 31 * result + (getWeddingHall() != null ? getWeddingHall().hashCode() : 0);
        result = 31 * result + (getTenant() != null ? getTenant().hashCode() : 0);
        result = 31 * result + getNumberOfGuests();
        result = 31 * result + getOccasion().hashCode();
        return result;
    }
}
