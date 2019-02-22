package com.app.resolver;

import java.util.Collections;
import java.util.List;

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

	public List<FieldModel> getFields(AssetModel assetModel) {
		List<FieldModel> fieldModelList = fieldRepository.findByAssetId(assetModel.getType());
		Collections.sort(fieldModelList, new FieldModel.SortBySortOrder());		
		return fieldModelList;
	}
}
