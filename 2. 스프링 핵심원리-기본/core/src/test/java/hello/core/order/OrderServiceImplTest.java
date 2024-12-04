package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    // 생성자 주입시, 필요한 구현체만을 가져와서 순수한 자바코드로 테스트를 함
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    // 생성자 주입을 해야하는 이유
    // 1. 불변 2.누락방지 3. final 키워드사용가능
    // 즉, 프레임 워크에 의존하지 않고 순수한 자바언어 특징을 잘 살리는 방법
    // 테스트 시에도 주입 클래스 확인 가능

}