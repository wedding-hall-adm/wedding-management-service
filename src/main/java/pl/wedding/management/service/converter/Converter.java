package pl.wedding.management.service.converter;

@FunctionalInterface
public interface Converter<DTO, ENTITY> {

    public DTO convertFromEntity(ENTITY entity);
}
