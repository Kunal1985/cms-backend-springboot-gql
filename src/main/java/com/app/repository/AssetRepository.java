package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.models.AssetModel;

public interface AssetRepository extends MongoRepository<AssetModel, String> {
}
