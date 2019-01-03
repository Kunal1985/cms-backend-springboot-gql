package com.app.dto;

public class FieldValueDTO {
	private String key;
	private String value;

	public FieldValueDTO() {
	}

	public FieldValueDTO(FieldValueDTO fieldValueDTO) {
		this.key = fieldValueDTO.key;
		this.value = fieldValueDTO.value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
