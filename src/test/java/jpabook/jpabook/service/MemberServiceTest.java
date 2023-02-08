package jpabook.jpabook.service;

import jpabook.jpabook.domain.Member;
import jpabook.jpabook.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // JUnit 실행할 때 Spring이랑 엮어서 실행하려고 할 때
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception {
        //give
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //give
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 한다!!!

        //then
        fail("예외가 발생해야 한다.");
    }
}