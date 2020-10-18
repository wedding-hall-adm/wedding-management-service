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
    public ReservationEntity convertFromDto(@NonNull ReservationDto dto) {
        return new ReservationEntity(dto.getId(),
                dto.getReservationStart() == null ? null : dto.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                dto.getReservationEnd() == null ? null : dto.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                dto.getWeddingHall() == null ? null : dto.getWeddingHall(),
                dto.getTenant() == null ? null : dto.getTenant(),
                dto.getNumberOfGuests(),
                dto.getOccasion() == null ? null : dto.getOccasion());
    }
}
