package br.com.familyfinances.incomeservice.form;

import br.com.familyfinances.incomeservice.model.Income;

public class TithingStatusForm {

	private Boolean tithingStatus;
	
	public TithingStatusForm(Income income) {
		this.tithingStatus = income.getTithingStatus();
	}

	public Boolean getTithingStatus() {
		return tithingStatus;
	}

	public void setTithingStatus(Boolean tithingStatus) {
		this.tithingStatus = tithingStatus;
	}
}
