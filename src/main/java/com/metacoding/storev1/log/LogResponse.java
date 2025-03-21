package com.metacoding.storev1.log;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO : Data Transfer Object -> 화면에 필요한 데이터만 있는 오브젝트
public class LogResponse {

    @AllArgsConstructor
    @Data // 내부에 getter, setter, toString 이 들어있음
    public static class ListPage {
        private int id;
        private String name;
        private int qty;
        private int total_price;
        private String buyer;

        // public ListPage(int id, String name, int qty, int total_price, String buyer) {
        //     this.id = id;
        //     this.name = name;
        //     this.qty = qty;
        //     this.total_price = total_price;
        //     this.buyer = buyer;
        // } @AllArgsConstructor 안에 있음!

    // @Override
    // public String toString() {
    //     return "ListPage [id=" + id + ", name=" + name + ", qty=" + qty + ", total_price=" + total_price + ", buyer=" + buyer + "]";
    // } 이게 위에 @Data 안에 이미 들어있음!
        
    }
}
