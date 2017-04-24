package pojo;

import enums.Sex;

public class PojoDAO {
	Long id;
	String roleName;
	String note;
	Sex sex;
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		System.out.println("test");
		this.sex = sex;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
