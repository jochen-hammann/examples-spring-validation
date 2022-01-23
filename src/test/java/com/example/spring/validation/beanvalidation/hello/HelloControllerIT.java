package com.example.spring.validation.beanvalidation.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIT
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Unit Tests] ==============================

    // -------------------- [Test Helper Classes] --------------------

    // -------------------- [Test Helper Methods] --------------------

    // -------------------- [Test Initialization] --------------------

    // -------------------- [Tests] --------------------

    @Test
    void postTest() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    void nonEmptyTest1() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty(null);
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void nonEmptyTest2() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void nonBlankTest1() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank(null);
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void nonBlankTest2() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void nonBlankTest3() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("           ");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void min10max20Test1() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(5L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void min10max20Test2() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(25L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void min10max20Test3() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(null);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void phoneTest1() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("12345678");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void phoneTest2() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("123456789012345");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void phoneTest3() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone(null);

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void phoneTest4() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void phoneTest5() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("abc");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void multipleErrorsTest() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("");
        hello.setNonBlank(null);
        hello.setMin10max20(25L);
        hello.setPhone("abc");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void postWithQueryParameter() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello/with/param").contentType(MediaType.APPLICATION_JSON).param("myparam", "1").content(jsonStr))
           .andDo(print())
           .andExpect(status().isNoContent());
    }

    @Test
    void postWithWrongQueryParameter() throws Exception
    {
        Hello hello = new Hello();
        hello.setNonEmpty("Foo");
        hello.setNonBlank("Bar");
        hello.setMin10max20(15L);
        hello.setPhone("1234567890");

        String jsonStr = this.objectMapper.writeValueAsString(hello);

        mvc.perform(post("/hello/with/param").contentType(MediaType.APPLICATION_JSON).param("myparam", "-1").content(jsonStr))
           .andDo(print())
           .andExpect(status().isBadRequest());
    }
}
