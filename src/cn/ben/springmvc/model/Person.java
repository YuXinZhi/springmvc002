package cn.ben.springmvc.model;

import java.util.Date;

public class Person {
	private String Name;
	private Integer age;
	private Date birthday;
	

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [name=" + Name + ", age=" + age + ", birthday="
				+ birthday + "]";
	}

}
