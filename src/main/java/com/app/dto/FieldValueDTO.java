package com.app.dto;

public class FieldValueDTO {
	private String key;
	private String value;
	private String dataType;
	private Boolean isAssetRef;

	public FieldValueDTO() {
	}

	public FieldValueDTO(FieldValueDTO fieldValueDTO) {
		this.key = fieldValueDTO.key;
		this.value = fieldValueDTO.value;
		this.dataType = fieldValueDTO.dataType;
		this.isAssetRef = fieldValueDTO.isAssetRef;
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

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean getIsAssetRef() {
		return isAssetRef;
	}

	public void setIsAssetRef(Boolean isAssetRef) {
		this.isAssetRef = isAssetRef;
	}

}
