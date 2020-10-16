package pl.wedding.management.service.weddinghall.model;

import lombok.*;

import java.util.EnumSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeddingHall {
    private Set<TypesOfHalls> typesOfHalls = EnumSet.allOf(TypesOfHalls.class);
    private String owner;
    private int max_guests;
}
