package pl.wedding.management.service.reservation.domain.converter;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.wedding.management.service.converter.RowFactory;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@NoArgsConstructor
public class ReservationRowFactory implements RowFactory<ReservationDto, ReservationEntity> {

    @Override
    public ReservationEntity convertFromDto(@NonNull ReservationDto dto) {
        return new ReservationEntity(dto.getId(),
                getDateTime(dto.getReservationStart()),
                getDateTime(dto.getReservationEnd()),
                dto.getWeddingHall(),
                dto.getTenant(),
                dto.getNumberOfGuests(),
                dto.getOccasion());
    }

    private LocalDateTime getDateTime(LocalDateTime dateTime) {
        return Optional.ofNullable(dateTime)
                .map(input -> input.truncatedTo(ChronoUnit.MINUTES))
                .orElse(null);
    }
}
