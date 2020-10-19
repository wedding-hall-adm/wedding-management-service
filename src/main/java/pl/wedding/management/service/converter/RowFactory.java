package pl.wedding.management.service.converter;

@FunctionalInterface
public interface RowFactory<DTO, ENTITY> {

    public ENTITY convertFromDto(DTO dto);
}
