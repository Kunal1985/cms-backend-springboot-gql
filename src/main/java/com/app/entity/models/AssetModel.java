package com.app.entity.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset")
public class AssetModel {
	@Indexed(unique = true)
	private String type;

	public AssetModel() {

	}

	public AssetModel(AssetModel assetModel) {
		this.type = assetModel.type;
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

		AssetModel author = (AssetModel) o;

		return type.equals(author.type);
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}

	@Override
	public String toString() {
		return String.format("AssetModel { type: '%s'}", type);
	}
}
