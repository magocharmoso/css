package pt.ul.fc.css.tascaeats.DTOs;

import pt.ul.fc.css.tascaeats.entities.address.Address;

public class AddressDTO {
    private Long addressId;
    private String address;
    private String codigoPostal;
    private String doorNum;
    private String floor;
    private String local;

    public AddressDTO(Long addressId, String address, String codigoPostal, String doorNum, String floor, String local) {
        this.addressId = addressId;
        this.address = address;
        this.codigoPostal = codigoPostal;
        this.doorNum = doorNum;
        this.floor = floor;
        this.local = local;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCodigoPostal() {return codigoPostal;}
    public void setCodigoPostal(String codigoPostal) {this.codigoPostal = codigoPostal;}

    public String getDoorNum() {return doorNum;}
    public void setDoorNum(String doorNum) {this.doorNum = doorNum;}

    public String getFloor() {return floor;}
    public void setFloor(String floor) {this.floor = floor;}

    public String getLocal() {return local;}
    public void setLocal(String local) {this.local = local;}

    @Override
    public String toString(){
        return local.toUpperCase() + " "
                + address.toUpperCase() + " "
                + doorNum.toUpperCase() + " "
                + floor.toUpperCase() + " "
                + codigoPostal.toUpperCase();
    }

    public static AddressDTO fromEntity(Address a) {
        return new AddressDTO(a.getAddressId(), a.getAddress(), a.getCodigoPostal(), a.getDoorNum(), a.getFloor(), a.getLocal());
    }
}
