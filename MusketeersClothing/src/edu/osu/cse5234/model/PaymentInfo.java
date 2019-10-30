package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CARD_NUM")
	private String cardNumber;
	@Column(name="EXP_DATE")
	private String epirationDate;
	@Column(name="CVV")
	private String cvv;
	@Column(name="HOLDER_NAME")
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
