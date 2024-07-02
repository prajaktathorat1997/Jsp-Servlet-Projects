package com.example.ProductCategory.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Avaibility {
private boolean inStack;
private int quantity;


public Avaibility() {
	super();
	// TODO Auto-generated constructor stub
}


public boolean isInStack() {
	return inStack;
}


public void setInStack(boolean inStack) {
	this.inStack = inStack;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public Avaibility(boolean inStack, int quantity) {
	super();
	this.inStack = inStack;
	this.quantity = quantity;
}


@Override
public String toString() {
	return "Avaibility [inStack=" + inStack + ", quantity=" + quantity + "]";
}
}
