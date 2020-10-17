package pl.wedding.management.service.weddinghall.model;

import lombok.*;

@Builder
@Value
public class AddressHall {
    String country;
    String city;
    String street;
    int numberBuilding;
    String postCode;
}
