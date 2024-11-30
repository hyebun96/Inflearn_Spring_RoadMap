package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefiinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefiinitionName);
            System.out.println("name = " + beanDefiinitionName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefiinitionName : beanDefinitionNames) {
            // 빈에 대한 정보 뽑기
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefiinitionName);

            // ROLE_APPLICATION : 스프링 내부가 아니라 사용자가 등록한 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefiinitionName);
                System.out.println("name = " + beanDefiinitionName + ", object = " + bean);
            }

        }
    }


}