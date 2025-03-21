package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Import(LogRepository.class)
@DataJpaTest // em loc 등록
public class LogRepositoryTest {

    @Autowired // DI 하는 어노테이션 새로운 방법, 깃발 보고 꽂아주는 거와 같음 (어노테이션을 이용한 것)
    private LogRepository logRepository;

    @Test // 얘 붙이면 세모 버튼이 생김
    public void findAllJoinStore_test() { // 매개변수에 아무것도 적을 수 없다!
       List<LogResponse.ListPage> logList =  logRepository.findAllJoinStore();
       for (ListPage listPage : logList) {
        System.out.println(listPage);
       }
    }
}
