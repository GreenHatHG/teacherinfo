package team.weacsoft.teacherinfo.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
public class UpdateTest extends Junit5Factory {

    @Test
    public void updateNameByIdTest() throws Exception {
        this.mockMvc.perform(put("/teacherinfos/name/100/10"))
                .andExpect(status().isOk())
                .andDo(document("updateNameById"));
    }

    @Test
    public void updateJobNumberByIdTest() throws Exception {
        this.mockMvc.perform(put("/teacherinfos/jobnumber/100/10"))
                .andExpect(status().isOk())
                .andDo(document("updateJobNumberById"));
    }

    @Test
    public void updateOfficeByIdTest() throws Exception {
        this.mockMvc.perform(put("/teacherinfos/office/100/10"))
                .andExpect(status().isOk())
                .andDo(document("updateOfficeById"));
    }

    @Test
    public void updatePhoneByIdTest() throws Exception {
        this.mockMvc.perform(put("/teacherinfos/phone/100/10"))
                .andExpect(status().isOk())
                .andDo(document("updatePhoneById"));
    }

    @Test
    public void updateFtpPasswordByIdTest() throws Exception {
        this.mockMvc.perform(put("/teacherinfos/ftppassword/100/10"))
                .andExpect(status().isOk())
                .andDo(document("updateFtpPasswordById"));
    }

    @Test
    public void updateTest() throws Exception {
        String json = "\t{\n" +
                "\t\t\"name\":\"1000\",\n" +
                "\t\t\"jobNumber\":\"20\",\n" +
                "\t\t\"office\":\"30\",\n" +
                "\t\t\"phone\":\"20\",\n" +
                "\t\t\"ftpNumber\":\"120\",\n" +
                "\t\t\"ftpPassword\":\"20\"\n" +
                "\t}";
        this.mockMvc.perform(put("/teacherinfos")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("update"));
    }
}
