package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();

            //  객체의 초기화는 생성된 이후이기 때문에 url = null이 뜬다.
            // 객체 생성과 초기화는 분리해야함, 객체를 생성하는 것은 단일 책임에 집중하는 것이 좋다. -> 유지보수 관점에서 좋음
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
