package pl.wedding.management.service.converter;

public interface RowFactory<DTO, ENTITY> {

    public ENTITY convertFromDto(DTO dto);
}
