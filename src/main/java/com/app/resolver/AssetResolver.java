package com.app.resolver;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.models.AssetModel;
import com.app.entity.models.FieldModel;
import com.app.repository.FieldRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class AssetResolver implements GraphQLResolver<AssetModel> {
	@Autowired
	private HttpSession httpSession;
	private FieldRepository fieldRepository;

	public AssetResolver(FieldRepository fieldRepository) {
		this.fieldRepository = fieldRepository;
	}

	public Iterable<FieldModel> getFields(AssetModel assetModel) {
		return fieldRepository.findByAssetId(assetModel.getType());
	}
}
