package api.payload;

import java.time.LocalDateTime;
import java.util.Date;

//POJO class ---plain old java object
//JSON -- JavaScript Object Notation
public class Store {	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	int id;
	int petId;
	int quantity;
	Date shipDate;
	String status;
	Boolean complete;
		
}
