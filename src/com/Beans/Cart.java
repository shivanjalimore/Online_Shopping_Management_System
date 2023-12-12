package com.Beans;

public class Cart 
{
  private int  CartId;
  private int  productID;
  private int   Quantity;
  private float  Price;
  private String s;
public int getCartId() {
	return CartId;
}
public void setCartId(int cartId) {
	CartId = cartId;
}
public int getProductID() {
	return productID;
}
public void setProductID(int productID) {
	this.productID = productID;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public float getPrice() {
	return Price;
}
public void setPrice(float price) {
	Price = price;
}
public String getS() {
	return s;
}
public void setS(String s) {
	this.s = s;
}

}
