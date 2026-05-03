package hellojpa;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private long deliveryId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }
}
