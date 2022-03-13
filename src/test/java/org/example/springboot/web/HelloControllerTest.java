package org.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Junit에 내장된 실행자 외 다른 실행자(SpringRunner) 실행
@WebMvcTest(controllers = HelloController.class) // Web 관련 어노테이션 @Controller나 @ControllerAdvice 사용 가능
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean 주입받기
    private MockMvc mvc; // 웹 API 테스트 스프링 MVC 테스트의 시작. HTTP GET, POST 등에 대한 API 테스트

    @Test
    public void hello_returning() throws Exception{
        String hello = "hello";

        
        mvc.perform(get("/hello")) // MockMvc로 /hello 주소로 HTTP Get 요청함
                .andExpect(status().isOk()) // perform의 결과, HTTP header의 status 검증
                .andExpect(content().string(hello)); // perform의 결과, 응답 본문의 내용 검증(Controller에서 hello 리턴하기 때문에 맞는지 검증함)
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name ="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name) // param: API 테스트할때 사용될 요청 파라미터 설정 String만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // jsonPath: JSON 응답값을 필드별로 검증 $기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));



    }
}
