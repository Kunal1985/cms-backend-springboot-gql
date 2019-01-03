package com.app.dto;

import java.util.List;

public class AssetValueDTO {
	private String assetValueId;
	private String type;
	private List<FieldValueDTO> fieldValues;

	public AssetValueDTO() {
	}

	public AssetValueDTO(AssetValueDTO assetValueDTO) {
		this.assetValueId = assetValueDTO.assetValueId;
		this.type = assetValueDTO.type;
		this.fieldValues = assetValueDTO.fieldValues;
	}

	public String getAssetValueId() {
		return assetValueId;
	}

	public void setAssetValueId(String assetValueId) {
		this.assetValueId = assetValueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FieldValueDTO> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(List<FieldValueDTO> fieldValues) {
		this.fieldValues = fieldValues;
	}
}
