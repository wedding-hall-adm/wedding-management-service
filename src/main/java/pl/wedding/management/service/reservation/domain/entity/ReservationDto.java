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

    public final Long id;

    public final LocalDateTime reservationStart;
    public final LocalDateTime reservationEnd;

    public final Object weddingHall; //to be changed
    public final Object tenant; //to be changed

    public Integer numberOfGuests;

    public final Occasion occasion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDto that = (ReservationDto) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getReservationStart() != null ? !getReservationStart().equals(that.getReservationStart()) : that.getReservationStart() != null)
            return false;
        if (getReservationEnd() != null ? !getReservationEnd().equals(that.getReservationEnd()) : that.getReservationEnd() != null)
            return false;
        /* todo
        if (getWeddingHall() != null ? !getWeddingHall().equals(that.getWeddingHall()) : that.getWeddingHall() != null)
            return false;
        if (getTenant() != null ? !getTenant().equals(that.getTenant()) : that.getTenant() != null) return false;
         */
        if (getNumberOfGuests() != null ? !getNumberOfGuests().equals(that.getNumberOfGuests()) : that.getNumberOfGuests() != null)
            return false;
        return getOccasion() == that.getOccasion();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getReservationStart() != null ? getReservationStart().hashCode() : 0);
        result = 31 * result + (getReservationEnd() != null ? getReservationEnd().hashCode() : 0);
        /* todo
        result = 31 * result + (getWeddingHall() != null ? getWeddingHall().hashCode() : 0);
        result = 31 * result + (getTenant() != null ? getTenant().hashCode() : 0);
         */
        result = 31 * result + (getNumberOfGuests() != null ? getNumberOfGuests().hashCode() : 0);
        result = 31 * result + (getOccasion() != null ? getOccasion().hashCode() : 0);
        return result;
    }
}
