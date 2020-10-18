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
    private Long id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private Object weddingHall; //to be changed
    private Object tenant; //to be changed
    private Integer numberOfGuests;
    @Enumerated(EnumType.STRING)
    private Occasion occasion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
