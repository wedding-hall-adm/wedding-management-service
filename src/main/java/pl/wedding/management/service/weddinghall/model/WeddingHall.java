package pl.wedding.management.service.weddinghall.model;

import lombok.*;

import java.util.EnumSet;
import java.util.Set;

@Getter
@Value
@Builder
@AllArgsConstructor

public class WeddingHall {
    private Set<TypesOfHalls> typesOfHalls = EnumSet.allOf(TypesOfHalls.class);
    private Set<HallsEquipment> hallEquipment = EnumSet.allOf(HallsEquipment.class);
    private String owner;
    private int max_guests;
}
