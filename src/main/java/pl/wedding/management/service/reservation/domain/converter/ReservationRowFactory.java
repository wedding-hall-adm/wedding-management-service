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

    private LocalDateTime getDateTime(LocalDateTime input) {
        Optional<LocalDateTime> optionalLocalDateTime = Optional.ofNullable(input);
        if (optionalLocalDateTime.isPresent())
            return optionalLocalDateTime.get().truncatedTo(ChronoUnit.MINUTES);
        return null;
    }

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
}
