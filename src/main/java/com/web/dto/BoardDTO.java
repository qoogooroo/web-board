package com.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

	private int biNum;
	private int uiNum;
	private String biTitle;
	private String biContent;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String uiName;
}
