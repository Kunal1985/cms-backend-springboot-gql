package com.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.models.FieldModel;

public interface FieldRepository extends MongoRepository<FieldModel, String> {
	List<FieldModel> findByAssetId(String assetId);

	List<FieldModel> findByAssetIdAndName(String assetId, String name);
}
