package com.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

	private int uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String uiGrade;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
}
