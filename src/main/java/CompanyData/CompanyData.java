package CompanyData;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@Builder
public class CompanyData {
    @Id
    private String name;
    private String country;
    private String city;
    private String street;
    private int streetNumber;
    private int apartmentNumber;
    private int companySize;
    private String creationDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    static CompanyData createCompanyData(CompanyDataDTO companyDataDTO) {
        CompanyData companyData = new CompanyData();
        companyData.setName(companyDataDTO.getName());
        companyData.setCountry(companyDataDTO.getCountry());
        companyData.setCity(companyDataDTO.getCity());
        companyData.setStreet(companyDataDTO.getStreet());
        companyData.setApartmentNumber(companyDataDTO.getApartmentNumber());
        companyData.setStreet(companyDataDTO.getStreet());
        companyData.setStreet(companyDataDTO.getStreet());
        companyData.setStreet(companyDataDTO.getStreet());
        companyData.setStreet(companyDataDTO.getStreet());
        companyData.setCompanyType(companyDataDTO.getCompanyType());

        return companyData;
    }
}
