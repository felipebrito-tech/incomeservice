package br.com.familyfinances.incomeservice.dto;

import java.time.format.DateTimeFormatter;

import br.com.familyfinances.incomeservice.model.Income;

public class IncomeDto {

	private Long id;

	private String date;

	private Double amount;

	private String description;

	private String payer;

	private Double amountForTithing;

	private Boolean tithingStatus;
	
	public IncomeDto(Income income) {
		this.id = income.getId();
		this.date = income.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.amount = income.getAmount();
		this.description = income.getDescription();
		this.payer = income.getPayer();
		this.amountForTithing = income.getAmountForTithing();
		this.tithingStatus = income.getTithingStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Double getAmountForTithing() {
		return amountForTithing;
	}

	public void setAmountForTithing(Double amountForTithing) {
		this.amountForTithing = amountForTithing;
	}

	public Boolean getTithingStatus() {
		return tithingStatus;
	}

	public void setTithingStatus(Boolean tithingStatus) {
		this.tithingStatus = tithingStatus;
	}
}
