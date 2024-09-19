package dto;

public class LenderDTO {

    public int lender_id;
    public String name;
    public String address;
    public int postalCode;
    public String city;

    public LenderDTO(int lender_id, String name, String address, int postalCode, String city) {
        this.lender_id = lender_id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getLender_id() {
        return lender_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "LenderDTO{" +
                "lender_id=" + lender_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                '}';
    }
}
