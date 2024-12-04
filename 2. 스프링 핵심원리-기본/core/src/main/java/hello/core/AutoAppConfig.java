package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동 등록 빈이 우선권을 갖음
    // Overriding bean definition for bean : 수동 빈이 자동빈 오버라이드
    //    @Bean(name = "memoryMemberRepository")
    //    MemberRepository memberRepository() {
    //        return new MemoryMemberRepository();
    //    }

}
