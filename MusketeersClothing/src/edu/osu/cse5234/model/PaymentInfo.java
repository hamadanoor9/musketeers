package edu.osu.cse5234.model;

public class PaymentInfo {
	private int id;
	private String cardNumber;
	private String epirationDate;
	private String cvv;
	private String holderName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getEpirationDate() {
		return epirationDate;
	}
	public void setEpirationDate(String epirationDate) {
		this.epirationDate = epirationDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
}
