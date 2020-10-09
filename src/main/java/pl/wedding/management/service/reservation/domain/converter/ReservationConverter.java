package pl.wedding.management.service.reservation.domain.converter;

import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.temporal.ChronoUnit;

public class ReservationConverter extends Converter<ReservationDto, ReservationEntity> {

    public ReservationConverter() {
        super(ReservationConverter::convertToDto);
    }

    private static ReservationDto convertToDto(ReservationEntity reservationEntity) {
        return new ReservationDto(reservationEntity.getId(),
                reservationEntity.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                reservationEntity.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                reservationEntity.getWeddingHall(),
                reservationEntity.getTenant(),
                reservationEntity.getNumberOfGuests(),
                reservationEntity.getOccasion());
    }

    @Override
    public ReservationDto convertFromEntity(ReservationEntity reservationEntity) {
        return convertToDto(reservationEntity);
    }
}
