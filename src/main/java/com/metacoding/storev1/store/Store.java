package com.metacoding.storev1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new 할 때 사용함.
@Table(name = "store_tb")
@Entity // 설정 파일에서 테이블을 생성해 준다.
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private String name; // 상품명
    private Integer stock; // 재고
    private Integer price; // 가격

    public void 재고감소(int qty) {
        this.stock = this.stock - qty;
    }
}
