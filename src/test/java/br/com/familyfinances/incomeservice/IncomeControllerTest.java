package br.com.familyfinances.incomeservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.familyfinances.incomeservice.dto.IncomeDto;
import br.com.familyfinances.incomeservice.form.IncomeForm;
import br.com.familyfinances.incomeservice.form.TithingStatusForm;
import br.com.familyfinances.incomeservice.model.Income;

public class IncomeControllerTest extends IncomeApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void whenList_thenReturns200() throws Exception {
		this.mockMvc.perform(get("/incomes")).andExpect(status().isOk());
	}

	@Test
	public void whenDetails_thenReturns200() throws Exception {
		this.mockMvc.perform(get("/incomes/1")).andExpect(status().isOk());
	}
	
	@Test
	public void whenSaving_thenReturns201() throws Exception {
		Income income = new Income();
		String incomeForm = this.objectMapper.writeValueAsString(new IncomeForm(income));
		String expected = this.objectMapper.writeValueAsString(new IncomeDto(income));
		
		MvcResult result = this.mockMvc.perform(post("/incomes").content(incomeForm))
										.andExpect(status().isCreated())
										.andReturn();

		assertThat(expected)
			.isEqualToIgnoringWhitespace(result.getResponse().getContentAsString());
	}
	
	@Test
	public void whenUpdating_thenReturns200() throws Exception {
		Income income = new Income();
		income.setTithingStatus(true);

		String tithingStatusForm = this.objectMapper.writeValueAsString(new TithingStatusForm(income));
		String expected = this.objectMapper.writeValueAsString(new IncomeDto(income));
		
		MvcResult result = this.mockMvc.perform(patch("/incomes/1").content(tithingStatusForm))
										.andExpect(status().isOk())
										.andReturn();

		assertThat(expected)
			.isEqualToIgnoringWhitespace(result.getResponse().getContentAsString());
	}
	
	@Test
	public void whenDeleting_thenReturns200() throws Exception {
		this.mockMvc.perform(delete("/incomes/1")).andExpect(status().isOk());
	}
}
