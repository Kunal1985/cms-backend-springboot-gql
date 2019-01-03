package com.app.resolver;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.entity.models.AssetModel;
import com.app.entity.models.AssetValueModel;
import com.app.entity.models.FieldModel;
import com.app.entity.models.FieldValueModel;
import com.app.entity.models.UserModel;
import com.app.exception.AnonymousAccessException;
import com.app.repository.AssetRepository;
import com.app.repository.AssetValueRepository;
import com.app.repository.FieldRepository;
import com.app.repository.FieldValueRepository;
import com.app.repository.UserRepository;
import com.app.utils.CommonUtils;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
	@Autowired
	private HttpSession httpSession;
	private AssetRepository assetRepository;
	private AssetValueRepository assetValueRepository;
	private FieldRepository fieldRepository;
	private FieldValueRepository fieldValueRepository;
	private UserRepository userRepository;

	public Query(AssetRepository assetRepository, AssetValueRepository assetValueRepository,
			FieldRepository fieldRepository, FieldValueRepository fieldValueRepository, UserRepository userRepository) {
		this.assetRepository = assetRepository;
		this.assetValueRepository = assetValueRepository;
		this.fieldRepository = fieldRepository;
		this.fieldValueRepository = fieldValueRepository;
		this.userRepository = userRepository;
	}

	public Iterable<AssetModel> findAllAssets() throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return assetRepository.findAll();
	}

	public Iterable<AssetValueModel> findAllAssetValues() throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return assetValueRepository.findAll();
	}

	public Iterable<AssetValueModel> findAssetValuesByType(String assetType) throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return assetValueRepository.findByType(assetType);
	}

	public Iterable<FieldModel> findAllFields() throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return fieldRepository.findAll();
	}

	public Iterable<FieldValueModel> findAllFieldValues() throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return fieldValueRepository.findAll();
	}

	public Iterable<UserModel> findAllUsers() throws AnonymousAccessException {
		System.out.println("httpSession" + httpSession.getId());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!CommonUtils.checkAuthentication(authentication)) {
			throw new AnonymousAccessException();
		}
		return userRepository.findAll();
	}

}
