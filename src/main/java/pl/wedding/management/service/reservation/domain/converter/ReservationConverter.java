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

    private LocalDateTime getDateTime(LocalDateTime input) {
        Optional<LocalDateTime> optionalLocalDateTime = Optional.ofNullable(input);
        if (optionalLocalDateTime.isPresent())
            return optionalLocalDateTime.get().truncatedTo(ChronoUnit.MINUTES);
        return null;
    }

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
}
