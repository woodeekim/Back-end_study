package jpabook.shop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


// DB 마다 다르긴하지만 order by 때문에 예약어로 걸려있기 때문에 테이블명을 따로 명시해준다.
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memeberId;

    private LocalDateTime orderDate;

    // Enum 을 사용했을 때 @Enumerated 와 String 으로 해야한다. ORDINAL 를 할 경우 순서가 꼬여서 들어가는 장애가 발생한다.
    @Enumerated(value = EnumType.STRING )
    private OrderStatus status;

}
