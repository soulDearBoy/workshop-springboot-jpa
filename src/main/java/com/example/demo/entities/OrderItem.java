package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;
import com.example.demo.entities.Order;

import com.example.demo.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_name")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	private Integer quantities;
	private Double price;

	public OrderItem() {

		this.id = new OrderItemPK();
	}

	public OrderItem(Order order, Product product, Integer quantities, Double price) {
		super();
		this.id = new OrderItemPK();
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantities = quantities;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}
    
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
