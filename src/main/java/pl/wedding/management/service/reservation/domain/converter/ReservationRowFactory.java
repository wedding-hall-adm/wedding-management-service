package pl.wedding.management.service.reservation.domain.converter;

import pl.wedding.management.service.reservation.domain.entity.ReservationEntity;
import pl.wedding.management.service.reservation.domain.entity.ReservationDto;

import java.time.temporal.ChronoUnit;

public class ReservationRowFactory extends RowFactory<ReservationDto, ReservationEntity> {

    public ReservationRowFactory() {
        super(ReservationRowFactory::convertToEntity);
    }

    private static ReservationEntity convertToEntity(ReservationDto reservationDto) {
        return new ReservationEntity(reservationDto.getId(),
                reservationDto.getReservationStart().truncatedTo(ChronoUnit.MINUTES),
                reservationDto.getReservationEnd().truncatedTo(ChronoUnit.MINUTES),
                reservationDto.getWeddingHall(),
                reservationDto.getTenant(),
                reservationDto.getNumberOfGuests(),
                reservationDto.getOccasion());
    }

    @Override
    public ReservationEntity convertFromDto(ReservationDto reservationDto) {
        return convertToEntity(reservationDto);
    }
}
