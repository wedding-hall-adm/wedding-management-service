package pl.wedding.management.service.reservation.domain.converter;

import java.util.function.Function;

abstract class Converter<DTO, ENTITY> {

    private Function<ENTITY, DTO> fromEntity;

    public Converter(Function<ENTITY, DTO> fromEntity) {
        this.fromEntity = fromEntity;
    }

    public abstract DTO convertFromEntity(ENTITY entity);

}
