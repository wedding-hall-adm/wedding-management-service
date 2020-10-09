package CompanyData;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CompanyDataDTO {
    private final String name;
    private final String country;
    private final String city;
    private final String street;
    private final int streetNumber;
    private final int apartmentNumber;
    private final int companySize;
    private final String creationDate;
    private final String description;
    private final CompanyType companyType;
}
