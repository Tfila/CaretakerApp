package pl.sullag.caretakerapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CaretakerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIfIndexPageIsSecured() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser
    public void testIfLoggedUserHasAccessToIndexPage() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("indexPage"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testIfAdminUserHasAccessToAdminPage() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("adminPage"));

    }

}
