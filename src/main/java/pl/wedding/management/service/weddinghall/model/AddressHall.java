package pl.wedding.management.service.weddinghall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressHall {
    private String country;
    private String city;
    private String street;
    private int numberBuilding;
    private String postCode;

}
