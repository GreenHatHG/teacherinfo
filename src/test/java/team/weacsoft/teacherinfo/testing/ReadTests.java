package team.weacsoft.teacherinfo.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
public class ReadTests extends Junit5Factory{

	@Test
	public void allTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos"))
				.andExpect(status().isOk())
				.andDo(document("findAll"));
	}

	@Test
	public void jobNumberTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/jobnumber/1"))
				.andExpect(status().isOk())
				.andDo(document("findByJobNumber"));
	}

	@Test
	public void nameTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/name/2"))
				.andExpect(status().isOk())
				.andDo(document("findByName"));
	}

	@Test
	public void officeTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/office/3"))
				.andExpect(status().isOk())
				.andDo(document("findByOffice"));
	}

	@Test
	public void phoneTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/phone/4"))
				.andExpect(status().isOk())
				.andDo(document("findByPhone"));
	}

	@Test
	public void ftpNumberTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/ftpnumber/100"))
				.andExpect(status().isOk())
				.andDo(document("findByFtpNumber"));
	}

	@Test
	public void countTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/count"))
				.andExpect(status().isOk())
				.andDo(document("Count"));
	}

	@Test
	public void jonNumberNUllTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/null/jobnumber"))
				.andExpect(status().isOk())
				.andDo(document("findJobnumberNull"));
	}

	@Test
	public void jonPhoneNUllTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/null/phone"))
				.andExpect(status().isOk())
				.andDo(document("findPhoneNull"));
	}

	@Test
	public void PageTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/page?page=2&size=4&item=jobNumber&sort=DESC"))
				.andExpect(status().isOk())
				.andDo(document("findAllPage"));
	}

	@Test
	public void SortTest() throws Exception {
		this.mockMvc.perform(get("/teacherinfos/jobNumber/AESC"))
				.andExpect(status().isOk())
				.andDo(document("findAllSort"));
	}


}