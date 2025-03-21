package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class StoreRepository {

    private EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }

    // 1번 : board 프로젝트의 BoardRepository 참고하기 / 삭제 쿼리 만들기
    public void deleteById(int id){
        Query query = em.createNativeQuery("delete from store_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void save(String name, int stock, int price){
        Query query = em.createNativeQuery("insert into store_tb(name, stock, price) values(?,?,?)"); // 얘도 jakarta
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate(); // insert, delete, update 할 때만 쓴다
    }

    public List<Store> findAll() {
        // 조건 : 오브젝트 매핑은 @Entity가 붙어야지만 가능하다. (디폴트 생성자를 호출)
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        return query.getResultList();
    }

    // TODO : 상세보기 1
    public Store findById(int id) {
        Query query = em.createNativeQuery("select * from store_tb where id = ?", Store.class);
        query.setParameter(1, id);

        try {
            return (Store) query.getSingleResult();
        } catch (Exception e) { // NoResultException 이 터짐
            return null;
        }
       
        // return (Store) query.getSingleResult();
    }


    public void updateById(int id, String name, String stock, String price) {
        Query query = em.createNativeQuery("update store_tb set name = ?, stock = ?, price = ? where id = ?");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.setParameter(4, id);
        query.executeUpdate();
    }
}