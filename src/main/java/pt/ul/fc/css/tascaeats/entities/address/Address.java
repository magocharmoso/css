package pt.ul.fc.css.tascaeats.entities.address;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long addressId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String codigoPostal;

    @Column(nullable = false)
    private String doorNum;

    @Column(nullable = false)
    private String floor;

    @Column(nullable = false)
    private String local;

    protected Address() {}

    public Long getAddressId() {return addressId;}

    public String getAddress() {return address;}
    public void setAddress(String newAddress) {this.address=newAddress;}

    public String getCodigoPostal() {return codigoPostal;}
    public void setCodigoPostal(String newCodigo) {this.codigoPostal=newCodigo;}

    public String getDoorNum() {return doorNum;}
    public void setDoorNum(String newDoor) {this.doorNum=newDoor;}

    public String getFloor() {return floor;}
    public void setFloor(String newFloor) {this.floor=newFloor;}

    public String getLocal() {return local;}
    public void setLocal(String newLocal) {this.local=newLocal;}

    @Override
    public String toString(){
        return local.toUpperCase() + " "
                + address.toUpperCase() + " "
                + doorNum.toUpperCase() + " "
                + floor.toUpperCase() + " "
                + codigoPostal.toUpperCase();
    }
}
