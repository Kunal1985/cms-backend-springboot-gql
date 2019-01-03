package com.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.models.FieldValueModel;

public interface FieldValueRepository extends MongoRepository<FieldValueModel, String> {
	List<FieldValueModel> findByAssetValueId(String assetValueId);
}
