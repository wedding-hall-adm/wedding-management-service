package pl.wedding.management.service.weddinghall.model;

import lombok.*;

import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
public class WeddingHall {
    private final Set<TypesOfHalls> typesOfHalls;
    private final Set<HallsEquipment> hallEquipment;
    private final String owner;
    private final int max_guests;
    private final int numberBuilding;

    public WeddingHall(Set<TypesOfHalls> typesOfHalls, Set<HallsEquipment> hallEquipment, String owner, int max_guests, int numberBuilding) {
        this.typesOfHalls = typesOfHalls;
        this.hallEquipment = hallEquipment;
        this.owner = owner;
        this.max_guests = max_guests;
        this.numberBuilding = numberBuilding;
    }
}
