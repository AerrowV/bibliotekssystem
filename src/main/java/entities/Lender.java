package entities;

public class Lender {

    public int lender_id;
    public String name;
    public String address;
    public int postalCode;

    public Lender(String name, String address, int postalCode) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
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

    public void setLender_id(int lender_id) {
        this.lender_id = lender_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "lender_id=" + lender_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
