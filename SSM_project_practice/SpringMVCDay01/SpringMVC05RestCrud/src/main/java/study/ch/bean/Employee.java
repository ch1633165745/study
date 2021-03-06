package study.ch.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {


	private Integer id;
	@NotEmpty//不能为空
	@Length(min = 6,max=18)//长度为6-18
	private String lastName;
	@Email(message = "注解属性的邮箱输入错误提示！")//满足email格式
	private String email;
	//1 male, 0 female
	private Integer gender;
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	@Past//必须为过去的时间
	private Date birth;

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	private Department department;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
					Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Date birth, Department department) {
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", birth=" + birth +
				", department=" + department +
				'}';
	}
}
