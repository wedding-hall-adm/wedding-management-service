package DTO;

public class CompanyData {
    private final String name;
    private final String country;
    private final String city;
    private final String street;
    private final int streetNumber;
    private final int apartmentNumber;
    private final String type;
    private final int companySize;
    private final String creationDate;
    private final String description;

    public CompanyData(String name, String country, String city, String street, int streetNumber, int apartmentNumber,
                       String type, int companySize, String creationDate, String description) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.type = type;
        this.companySize = companySize;
        this.creationDate = creationDate;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public String getStreet() {
        return this.street;
    }

    public int getStreetNumber() {
        return this.streetNumber;
    }

    public int getApartmentNumber() {
        return this.apartmentNumber;
    }

    public String getFullStreetAdress() {
        return apartmentNumber == 0
                ? street + " " + streetNumber
                : street + " " + streetNumber + "/" + apartmentNumber;
    }

    public String getType() {
        return this.type;
    }

    public int getCompanySize() {
        return companySize;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }
}
