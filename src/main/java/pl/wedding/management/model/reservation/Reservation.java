package pl.wedding.management.model.reservation;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

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

}
