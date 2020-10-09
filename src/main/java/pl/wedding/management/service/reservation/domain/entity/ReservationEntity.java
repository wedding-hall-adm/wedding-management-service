package pl.wedding.management.service.reservation.domain.entity;

import lombok.*;
import pl.wedding.management.service.reservation.domain.enums.Occasion;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private Object weddingHall; //to be changed
    private Object tenant; //to be changed
    private int numberOfGuests;
    @Enumerated(EnumType.STRING)
    private Occasion occasion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

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
