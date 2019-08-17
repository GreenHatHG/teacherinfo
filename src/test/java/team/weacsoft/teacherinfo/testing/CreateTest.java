package team.weacsoft.teacherinfo.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Disabled
public class CreateTest extends Junit5Factory {

    @Test
    public void InsertTest() throws Exception {
        String json = "[\n" +
                "  {\n" +
                "    \"name\": \"18\",\n" +
                "    \"jobNumber\": \"18\",\n" +
                "    \"office\": \"18\",\n" +
                "    \"phone\": \"18\",\n" +
                "    \"ftpNumber\": \"118\",\n" +
                "    \"ftpPassword\": \"18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"19\",\n" +
                "    \"jobNumber\": \"19\",\n" +
                "    \"office\": \"19\",\n" +
                "    \"phone\": \"19\",\n" +
                "    \"ftpNumber\": \"119\",\n" +
                "    \"ftpPassword\": \"19\"\n" +
                "  }\n" +
                "]";
        this.mockMvc.perform(post("/teacherinfos")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("Save"));
    }
}
