package cn.kgc.entity;

public class User {

	private Integer id;
	private String name;
	private String addr;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User(Integer id, String name, String addr) {
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	public User() {
		this.id = null;
		this.name = null;
		this.addr = null;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", addr='" + addr + '\'' +
				'}';
	}
}
