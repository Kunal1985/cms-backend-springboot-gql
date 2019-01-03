package com.app.entity.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fieldvalue")
public class FieldValueModel {
	@Id
	private String id;
	private String key;
	private String value;
	private String assetValueId;

	public FieldValueModel() {
	}

	public FieldValueModel(String id) {
		this.id = id;
	}

	public FieldValueModel(FieldValueModel fieldModel) {
		this.id = fieldModel.id;
		this.key = fieldModel.key;
		this.value = fieldModel.value;
		this.assetValueId = fieldModel.assetValueId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAssetValueId() {
		return assetValueId;
	}

	public void setAssetValueId(String assetValueId) {
		this.assetValueId = assetValueId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FieldValueModel field = (FieldValueModel) o;

		return id.equals(field.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return String.format("FieldValueModel { '%s': '%s', '%s', '%s'}", id, key, value, assetValueId);
	}
}
