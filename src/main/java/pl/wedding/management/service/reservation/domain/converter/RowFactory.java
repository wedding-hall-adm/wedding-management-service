package pl.wedding.management.service.reservation.domain.converter;

import java.util.function.Function;

abstract class RowFactory<DTO, ENTITY> {

    private Function<DTO, ENTITY> fromDto;

    public RowFactory(Function<DTO, ENTITY> fromDto) {
        this.fromDto = fromDto;
    }

    public abstract ENTITY convertFromDto(DTO dto);

}
