package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //반드시 String 타입으로 설정한다. ordinal로 설정하면 추후 상태값이 추가될 때 기존의 순서가 꼬인다.
    private DeliveryStatus deliveryStatus; //READY: 배송준비, COMP: 배송중
}
