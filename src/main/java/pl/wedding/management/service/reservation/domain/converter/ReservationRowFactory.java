package pl.wedding.management.service.reservation.domain.converter;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.wedding.management.service.converter.RowFactory;
import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

@NoArgsConstructor
public class ReservationRowFactory implements RowFactory<ReservationDto, ReservationEntity> {

    @Override
    public ReservationEntity convertFromDto(@NonNull ReservationDto dto) {
        return new ReservationEntity(dto.getId(),
                dto.getReservationStart(),
                dto.getReservationEnd(),
                dto.getWeddingHall(),
                dto.getTenant(),
                dto.getNumberOfGuests(),
                dto.getOccasion());
    }
}
