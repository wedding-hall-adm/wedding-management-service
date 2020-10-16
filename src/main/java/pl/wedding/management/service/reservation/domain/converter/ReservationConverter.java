package pl.wedding.management.service.reservation.domain.converter;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.wedding.management.service.converter.Converter;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.temporal.ChronoUnit;

@NoArgsConstructor
public class ReservationConverter implements Converter<ReservationDto, ReservationEntity> {

    @Override
    public ReservationDto convertFromEntity(@NonNull ReservationEntity reservationEntity) {
        return new ReservationDto(reservationEntity.getId(),
                reservationEntity.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                reservationEntity.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                reservationEntity.getWeddingHall(),
                reservationEntity.getTenant(),
                reservationEntity.getNumberOfGuests(),
                reservationEntity.getOccasion());
    }
}
