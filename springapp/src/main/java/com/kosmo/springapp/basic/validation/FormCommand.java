package com.kosmo.springapp.basic.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FormCommand {
	
	//폼의 파라미터명과 같게 속성(멤버변수)정의
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	
	@NotBlank(message = "나이를 입력하세요")
	@Pattern(regexp = "[0-9]{1,3}", message = "숫자만 입력해주세요")
	private String years;
	
	@NotNull(message = "성별을 선택하세요")
	private String gender;
	
	@NotNull(message = "관심사항을 선택하세요")
	@Size(min = 2,message = "최소 2개 이상 선택하세요")
	private String[] inter;
	
	@NotBlank(message = "학력을 선택하세요")
	private String grade;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getInter() {
		return inter;
	}

	public void setInter(String[] inter) {
		this.inter = inter;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
