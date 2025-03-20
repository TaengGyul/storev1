package com.metacoding.storev1.store;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;
    
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional // 이때만 jakarta가 아니라 org 임!!
    public void 상품등록(String name, int stock, int price) {

    }
}
