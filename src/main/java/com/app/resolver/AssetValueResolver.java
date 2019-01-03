package com.app.resolver;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.models.AssetValueModel;
import com.app.entity.models.FieldModel;
import com.app.entity.models.FieldValueModel;
import com.app.repository.FieldRepository;
import com.app.repository.FieldValueRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class AssetValueResolver implements GraphQLResolver<AssetValueModel> {
	@Autowired
	private HttpSession httpSession;
	private FieldRepository fieldRepository;
	private FieldValueRepository fieldValueRepository;

	public AssetValueResolver(FieldRepository fieldRepository, FieldValueRepository fieldValueRepository) {
		this.fieldRepository = fieldRepository;
		this.fieldValueRepository = fieldValueRepository;
	}

	public Iterable<FieldModel> getFields(AssetValueModel assetValueModel) {
		return fieldRepository.findByAssetId(assetValueModel.getType());
	}

	public Iterable<FieldValueModel> getFieldValues(AssetValueModel assetValueModel) {
		return fieldValueRepository.findByAssetValueId(assetValueModel.getId());
	}
}
