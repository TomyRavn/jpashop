package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    //양방향 연관관계 실습 예제 => 실제로는 Member와 Order를 조회할 때 따로 조회하는 것이 맞다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();     //JPA Hibernate에서는 관례상 ArrayList로 초기화 ; null 포인터 방지 등

    //setter의 사용은 코드추적 즉, 유지보수를 위해 최소화하고 생성자에서 가급적 값을 세팅하여 처리할 수 있도록 하는 것이 좋다.
    /** getter, setter */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
