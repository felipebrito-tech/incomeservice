package br.com.familyfinances.incomeservice.model;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDate date;

	private Double amount;

	private String description;

	private String payer;

	private Double amountForTithing;

	private Boolean tithingStatus;

	public Income() {
		this.id = 1L;
		this.date = LocalDate.of(2020, Month.MAY, 15);
		this.amount = 150.5;
		this.description = "Aula particular";
		this.payer = "Hugo";
		this.amountForTithing = 150.5;
		this.tithingStatus = false;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
