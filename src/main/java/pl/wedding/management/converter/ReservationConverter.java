package pl.wedding.management.converter;

import pl.wedding.management.model.reservation.Reservation;
import pl.wedding.management.model.reservation.ReservationDto;

public class ReservationConverter extends Converter<ReservationDto, Reservation> {

    public ReservationConverter() {
        super(ReservationConverter::convertToEntity, ReservationConverter::convertToDto);
    }

    private static ReservationDto convertToDto(Reservation reservation) {
        return new ReservationDto(reservation.getId(),
                reservation.getReservationStart(),
                reservation.getReservationEnd(),
                reservation.getWeddingHall(),
                reservation.getTenant(),
                reservation.getNumberOfGuests(),
                reservation.getOccasion());
    }

    private static Reservation convertToEntity(ReservationDto reservationDto) {
        return new Reservation(reservationDto.getId(),
                reservationDto.getReservationStart(),
                reservationDto.getReservationEnd(),
                reservationDto.getWeddingHall(),
                reservationDto.getTenant(),
                reservationDto.getNumberOfGuests(),
                reservationDto.getOccasion()
                );
    }

}
