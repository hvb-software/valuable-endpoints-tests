package software.hvb.blog.valuableendpointstests.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerJsonTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldListAllUsers() throws Exception {

        // when
        mockMvc.perform(
                        get("/users")
                                .contentType(APPLICATION_JSON)
                )

                // then
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(content().json("""
                        [
                            {
                                "id": 1,
                                "firstName": "Walter",
                                "lastName": "White"
                            },
                            {
                                "id": 2,
                                "firstName": "Jesse",
                                "lastName": "Pinkman"
                            }
                        ]
                        """, true));
    }
}