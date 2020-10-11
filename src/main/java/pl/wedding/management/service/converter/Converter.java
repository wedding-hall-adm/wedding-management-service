package pl.wedding.management.service.converter;

import java.util.function.Function;

public interface Converter<DTO, ENTITY> {

    public DTO convertFromEntity(ENTITY entity);
}
