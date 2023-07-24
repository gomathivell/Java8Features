package com.test.Java8Features;

public class Project {
    private String pname;
    private String teamLead;
    private String location;
    private Product product;
    
    public Project(String pname, String teamLead) {
	    this.pname = pname;
	    this.teamLead = teamLead;
    }
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
