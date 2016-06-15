package cn.ben.springmvc.model;

import java.util.Date;

public class User {
	private Integer age;
	private Date birthday;

	@Override
	public String toString() {
		return "User [age=" + age + ", birthday=" + birthday + "]";
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
}
