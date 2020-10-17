package pl.wedding.management.service.weddinghall.model;

import lombok.*;

@Getter
@Builder
@Value
@AllArgsConstructor
public class AddressHall {
    private String country;
    private String city;
    private String street;
    private int numberBuilding;
    private String postCode;

}
