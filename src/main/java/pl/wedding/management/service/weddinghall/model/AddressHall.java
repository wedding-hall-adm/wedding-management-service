package pl.wedding.management.service.weddinghall.model;

import lombok.*;

@Builder
@Getter
public class AddressHall {
    private final String country;
    private final String city;
    private final String street;
    private final int numberBuilding;
    private final String postCode;

    public AddressHall(String country, String city, String street, int numberBuilding, String postCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberBuilding = numberBuilding;
        this.postCode = postCode;
    }
}
