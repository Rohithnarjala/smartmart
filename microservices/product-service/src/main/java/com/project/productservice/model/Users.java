package com.project.productservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

@Entity
@Table(name="user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	@NotNull
	private int id;
	
	@Column(name="us_first_name")
	@NotNull
	private String firstName;
	
	@Column(name="us_last_name")
	@NotNull
	private String lastName;
	
	@Column(name="us_age")
	@NotNull
	private int age;
	
	@Column(name="us_gender")
	@NotNull
	private String gender;
	
	@Column(name="us_contact_number")
	@NotNull
	private long contactNumber;
	
	@Column(name="us_user_id")
	@NotNull
	private String userId;
	
	@Column(name="us_password")
	@NotNull
	private String password;
	
	@Column(name="us_user_type")
	@NotNull
	private String userType;
	
	@Column(name="us_reward_points",columnDefinition = "DECIMAL(8,2)")
	@NotNull
	private String userRewardPoints;
	
	@Column(name="us_status")
	//@NotNull
	private String status;
	
	@Column(name="us_question_1")
	@NotNull
	private String question1;
	
	@Column(name="us_answer_1")
	@NotNull
	private String answer1;
	
	@Column(name="us_question_2")
	@NotNull
	private String question2;
	
	@Column(name="us_answer_2")
	@NotNull
	private String answer2;
	
	@Column(name="us_question_3")
	@NotNull
	private String question3;
	
	@Column(name="us_answer_3")
	@NotNull
	private String answer3;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(@NotNull int id, @NotNull String firstName, @NotNull String lastName, @NotNull int age,
			@NotNull String gender, @NotNull long contactNumber, @NotNull String userId, @NotNull String password,
			@NotNull String userType, @NotNull String userRewardPoints, String status, @NotNull String question1,
			@NotNull String answer1, @NotNull String question2, @NotNull String answer2, @NotNull String question3,
			@NotNull String answer3) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.userRewardPoints = userRewardPoints;
		this.status = status;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
		this.question3 = question3;
		this.answer3 = answer3;
	}

	public String getUserRewardPoints() {
		return userRewardPoints;
	}

	public void setUserRewardPoints(String userRewardPoints) {
		this.userRewardPoints = userRewardPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
				+ gender + ", contactNumber=" + contactNumber + ", userId=" + userId + ", password=" + password
				+ ", userType=" + userType + ", userRewardPoints=" + userRewardPoints + ", status=" + status
				+ ", question1=" + question1 + ", answer1=" + answer1 + ", question2=" + question2 + ", answer2="
				+ answer2 + ", question3=" + question3 + ", answer3=" + answer3 + "]";
	}
	
	
}
