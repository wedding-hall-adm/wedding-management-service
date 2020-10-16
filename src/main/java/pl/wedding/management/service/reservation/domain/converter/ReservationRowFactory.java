package pl.wedding.management.service.reservation.domain.converter;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.wedding.management.service.converter.RowFactory;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.temporal.ChronoUnit;

@NoArgsConstructor
public class ReservationRowFactory implements RowFactory<ReservationDto, ReservationEntity> {

    @Override
    public ReservationEntity convertFromDto(@NonNull ReservationDto reservationDto) {
        return new ReservationEntity(reservationDto.getId(),
                reservationDto.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                reservationDto.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                reservationDto.getWeddingHall(),
                reservationDto.getTenant(),
                reservationDto.getNumberOfGuests(),
                reservationDto.getOccasion());
    }
}
