package alfagif.ru.alfagif.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void receiveSpecificGif() throws Exception{
        mockMvc.perform(get("/alfa-gif/usd"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

    @Test
    void checkResponse() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());
    }
}