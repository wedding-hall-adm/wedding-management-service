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
    public ReservationDto convertFromEntity(@NonNull ReservationEntity entity) {
        return new ReservationDto(entity.getId(),
                entity.getReservationStart() == null ? null : entity.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                entity.getReservationEnd() == null ? null : entity.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                entity.getWeddingHall() == null ? null : entity.getWeddingHall(),
                entity.getTenant() == null ? null : entity.getTenant(),
                entity.getNumberOfGuests() == 0 ? 0 : entity.getNumberOfGuests(),
                entity.getOccasion() == null ? null : entity.getOccasion());
    }
}
