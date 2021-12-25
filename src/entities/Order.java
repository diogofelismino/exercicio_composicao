package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enun.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void addOrderItem(OrderItem order) {
		orderItem.add(order);
	}
	
	public void removeOrderItem(OrderItem order) {
		orderItem.remove(order);
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem c: orderItem) {
			sum += c.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Summary:\n");
		sb.append("Order moment: " + sdf2.format(moment) +"\n");
		sb.append("Order status: " + status+ "\n");
		sb.append("Client: " + client.getName() + " ");
		sb.append("(" + sdf.format(client.getNascimento()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order item:\n");
		for(OrderItem c: orderItem) {
			sb.append(c.getProduct().getName() + ", ");
			sb.append("$" + c.getPrice() + ", ");
			sb.append("Quantity: " + c.getQuantity() + ", ");
			sb.append("subtotal: " + "$" + c.subTotal() + "\n");
		}
		sb.append("Total price: " + total());
		return sb.toString();
	}

}
