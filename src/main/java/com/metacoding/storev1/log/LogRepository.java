package com.metacoding.storev1.log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class LogRepository {
    private EntityManager em;

    // DI
    public LogRepository(EntityManager em) {
        this.em = em;
    }

    public List<LogResponse.ListPage> findAllJoinStore() {
        List<LogResponse.ListPage> logList = new ArrayList<>();
        String q = "SELECT lt.id, st.name, lt.qty, lt.total_price, lt.buyer FROM log_tb lt INNER JOIN store_tb st ON lt.store_id = st.id ORDER BY lt.id DESC"; // @Entity가 안 적혀 있으면 못 적는다! (맵핑을 안 해줌)
        Query query = em.createNativeQuery(q); // Quert import 할 때 jakarta 방식임!
        List<Object[]> obsList = (List<Object[]>) query.getResultList(); // Object[] -> ROW

        // ObjectMapping 이라고 한다!
        for (Object[] obs : obsList) {
            LogResponse.ListPage log = new LogResponse.ListPage(
                    (int) obs[0], (String) obs[1], (int) obs[2], (int) obs[3], (String) obs[4]);
            logList.add(log);
        }
        return logList;
    }
}
