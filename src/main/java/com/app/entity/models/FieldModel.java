package com.app.entity.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "field")
public class FieldModel {
	@Id
	private String id;

	private String name;

	private String dataType;

	private Boolean optional;

	private Boolean isMulti;

	private String multiType;

	private Boolean isAssetRef;

	private String assetId;

	public FieldModel() {
	}

	public FieldModel(String id) {
		this.id = id;
	}

	public FieldModel(FieldModel fieldModel) {
		this.name = fieldModel.name;
		this.dataType = fieldModel.dataType;
		this.optional = fieldModel.optional;
		this.isMulti = fieldModel.isMulti;
		this.multiType = fieldModel.multiType;
		this.isAssetRef = fieldModel.isAssetRef;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public Boolean getIsMulti() {
		return isMulti;
	}

	public void setIsMulti(Boolean isMulti) {
		this.isMulti = isMulti;
	}

	public String getMultiType() {
		return multiType;
	}

	public void setMultiType(String multiType) {
		this.multiType = multiType;
	}

	public Boolean getIsAssetRef() {
		return isAssetRef;
	}

	public void setIsAssetRef(Boolean isAssetRef) {
		this.isAssetRef = isAssetRef;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FieldModel field = (FieldModel) o;

		return id.equals(field.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return String.format(
				"FieldModel { identifier: '%s', name: '%s', dataType: '%s', optional: '%s', isMulti: '%s', multiType: '%s', isMultiSelect: '%s'}",
				id, name, dataType, optional, isMulti, multiType, isAssetRef);
	}
}
