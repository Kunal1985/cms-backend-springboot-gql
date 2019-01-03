package com.app.dto;

public class AssetDTO {
	private String type;
	private Iterable<String> fields;
	private Iterable<String> parents;
	private Iterable<String> children;

	public AssetDTO() {
	}

	public AssetDTO(AssetDTO assetModel) {
		this.type = assetModel.type;
		this.fields = assetModel.fields;
		this.parents = assetModel.parents;
		this.children = assetModel.children;
	}

	public Iterable<String> getFields() {
		return fields;
	}

	public void setFields(Iterable<String> fields) {
		this.fields = fields;
	}

	public Iterable<String> getParents() {
		return parents;
	}

	public void setParents(Iterable<String> parents) {
		this.parents = parents;
	}

	public Iterable<String> getChildren() {
		return children;
	}

	public void setChildren(Iterable<String> children) {
		this.children = children;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("AssetBean { type: '%s', fields: '%s', parents: '%s', children: '%s'}", type, fields,
				parents, children);
	}
}
