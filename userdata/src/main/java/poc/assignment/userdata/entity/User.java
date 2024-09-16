package poc.assignment.userdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = ("user_data"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	@NotNull(message = "{username}")
	private String userName;
	@Column(name = "sur_name")
	private String surName;
	@DateTimeFormat(pattern = "{dateOfJoining}")
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	@DateTimeFormat(pattern = "{dateOfBirth}")
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Digits(integer = 10, fraction = 0, message = "{MobileNo}")
	@Min(value = 1000000000, message = "{MobileNo}")
	@NotNull(message = "{mobileNo}")
	@Column(name = "mobile_no")
	private Long mobileNo;
	@Email(message = "{email}")
	@NotNull(message = "{email_id}")
	@Column(name = "email_id")
	private String email;
	@NotNull(message = "{city}")
	@Column(name = "city")
	private String city;
	@NotNull(message = "{state}")
	@Column(name = "state")
	private String state;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
}