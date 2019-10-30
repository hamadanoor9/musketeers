package edu.osu.cse5234.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import edu.osu.cse5234.business.view.*;
import edu.osu.cse5234.model.LineItem;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="CUSTOMER_EMAIL")
	private String emailAddress;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> items;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
	private PaymentInfo payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	private ShippingInfo shipping;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<LineItem> getItems() {
		return items;
	}
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	public PaymentInfo getPayment() {
		return payment;
	}
	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}
	public ShippingInfo getShipping() {
		return shipping;
	}
	public void setShipping(ShippingInfo shipping) {
		this.shipping = shipping;
	}
	
	
	
}
