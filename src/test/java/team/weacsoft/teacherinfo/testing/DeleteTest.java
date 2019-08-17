package team.weacsoft.teacherinfo.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Disabled
public class DeleteTest extends Junit5Factory {

    @Test
    public void DeleteOneTest() throws Exception {
        this.mockMvc.perform(delete("/teacherinfos/110"))
                .andExpect(status().isOk())
                .andDo(document("deleteById"));
    }
}
