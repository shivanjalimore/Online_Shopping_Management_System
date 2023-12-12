package com.Beans;

public class LoginInfo
{
  private int userID;
  private String password;
  private char userType;
  private int ADuserId2;
  private int CuserId;
public int getADuserId2() {
	return ADuserId2;
}
public void setADuserId2(int aDuserId2) {
	ADuserId2 = aDuserId2;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public char getUserType() {
	return userType;
}
public void setUserType(char userType) {
	this.userType = userType;
}
public int getCuserId() {
	return CuserId;
}
public void setCuserId(int cuserId) {
	CuserId = cuserId;
}

}
