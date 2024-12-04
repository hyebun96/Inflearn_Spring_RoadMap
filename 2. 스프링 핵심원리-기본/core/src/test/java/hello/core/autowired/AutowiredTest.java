package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        // Member은 @Bean이 아님
        // @Autowired만 사용하면 default값이 true임으로 자동 주입 대상이 없으면 오류 발생
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);     // 출력 X
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBea2 = " + noBean2);      // noBea2 = null
        }

        @Autowired
        public void setNoBean1(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);     // noBean3 = Optional.empty
        }

    }
 }
