package hbi.core.demo.dto;

import java.util.Date;

public class OrderMessage implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	public OrderMessage() {
		super();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String opderNumber) {
		this.orderNumber = opderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStaus) {
		this.orderStatus = orderStaus;
	}

	private String companyName;
	private String orderNumber;
	private String customerName;
	private Date orderDate;
	private String orderStatus;
	private Long orderMoney;
    private Long inventoryItemId;

	public Long getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(Long inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public Long getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(Long orderMoney) {
		this.orderMoney = orderMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
