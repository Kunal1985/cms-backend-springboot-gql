package com.app.entity.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assetvalue")
public class AssetValueModel {
	@Id
	private String id;
	private String type;

	public AssetValueModel() {
	}

	public AssetValueModel(String id) {
		this.id = id;
	}

	public AssetValueModel(AssetValueModel assetModel) {
		this.type = assetModel.type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AssetValueModel author = (AssetValueModel) o;

		return id.equals(author.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return String.format("AssetModel { id: '%s', type: '%s'}", id, type);
	}
}
