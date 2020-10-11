package pl.wedding.management.converter;

import pl.wedding.management.model.reservation.ReservationEntity;
import pl.wedding.management.model.reservation.ReservationDto;

public class ReservationConverter extends Converter<ReservationDto, ReservationEntity> {

    public ReservationConverter() {
        super(ReservationConverter::convertToEntity, ReservationConverter::convertToDto);
    }

    private static ReservationDto convertToDto(ReservationEntity reservationEntity) {
        return new ReservationDto(reservationEntity.getId(),
                reservationEntity.getReservationStart(),
                reservationEntity.getReservationEnd(),
                reservationEntity.getWeddingHall(),
                reservationEntity.getTenant(),
                reservationEntity.getNumberOfGuests(),
                reservationEntity.getOccasion());
    }

    private static ReservationEntity convertToEntity(ReservationDto reservationDto) {
        return new ReservationEntity(reservationDto.getId(),
                reservationDto.getReservationStart(),
                reservationDto.getReservationEnd(),
                reservationDto.getWeddingHall(),
                reservationDto.getTenant(),
                reservationDto.getNumberOfGuests(),
                reservationDto.getOccasion()
                );
    }

}
