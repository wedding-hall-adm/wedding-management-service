package pl.wedding.management.service.reservation.domain.converter;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.wedding.management.service.converter.Converter;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@NoArgsConstructor
public class ReservationConverter implements Converter<ReservationDto, ReservationEntity> {

    @Override
    public ReservationDto convertFromEntity(@NonNull ReservationEntity entity) {
        return new ReservationDto(entity.getId(),
                getDateTime(entity.getReservationStart()),
                getDateTime(entity.getReservationEnd()),
                entity.getWeddingHall(),
                entity.getTenant(),
                entity.getNumberOfGuests(),
                entity.getOccasion());
    }

    private LocalDateTime getDateTime(LocalDateTime dateTime) {
        return Optional.ofNullable(dateTime)
                .map(input -> input.truncatedTo(ChronoUnit.MINUTES))
                .orElse(null);
    }
}
