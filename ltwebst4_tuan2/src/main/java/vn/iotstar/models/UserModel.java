package vn.iotstar.models;

import java.io.Serializable;

public class UserModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String username;
	private String images;
	public UserModel() {
		super();
	}
	public UserModel(int id,  String username, String password, String email, String fullname, String images) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.username = username;
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname
				+ ", username=" + username + ", images=" + images + "]";
	}
	
}
