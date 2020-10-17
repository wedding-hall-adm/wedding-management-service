package pl.wedding.management.service.weddinghall.model;

import lombok.*;

import java.util.EnumSet;
import java.util.Set;

@Value
@Builder

public class WeddingHall {
    Set<TypesOfHalls> typesOfHalls;
    Set<HallsEquipment> hallEquipment;
    String owner;
    int max_guests;
}
