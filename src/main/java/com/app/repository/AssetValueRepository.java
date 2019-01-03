package com.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.models.AssetValueModel;

public interface AssetValueRepository extends MongoRepository<AssetValueModel, String> {
	List<AssetValueModel> findByType(String assetType);
}
