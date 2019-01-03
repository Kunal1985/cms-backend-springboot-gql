package com.app.resolver;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.beans.CredentialsBean;
import com.app.constants.Constants;
import com.app.dto.AssetDTO;
import com.app.dto.AssetValueDTO;
import com.app.dto.FieldValueDTO;
import com.app.entity.models.AssetModel;
import com.app.entity.models.AssetValueModel;
import com.app.entity.models.FieldModel;
import com.app.entity.models.FieldValueModel;
import com.app.entity.models.UserModel;
import com.app.exception.GenericGQLException;
import com.app.repository.AssetRepository;
import com.app.repository.AssetValueRepository;
import com.app.repository.FieldRepository;
import com.app.repository.FieldValueRepository;
import com.app.repository.UserRepository;
import com.app.response.dto.GenericDTO;
import com.app.utils.CommonUtils;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver, Constants {
	@Autowired
	private HttpSession httpSession;
	private AssetRepository assetRepository;
	private AssetValueRepository assetValueRepository;
	private FieldRepository fieldRepository;
	private FieldValueRepository fieldValueRepository;
	private UserRepository userRepository;

	public Mutation(AssetRepository assetRepository, AssetValueRepository assetValueRepository,
			FieldRepository fieldRepository, FieldValueRepository fieldValueRepository, UserRepository userRepository) {
		this.assetRepository = assetRepository;
		this.assetValueRepository = assetValueRepository;
		this.fieldRepository = fieldRepository;
		this.fieldValueRepository = fieldValueRepository;
		this.userRepository = userRepository;
	}

	public AssetModel newAsset(AssetDTO assetDTO) {
		System.out.println("assetDTO" + assetDTO);
		AssetModel assetModel = new AssetModel();
		assetModel.setType(assetDTO.getType());
		assetRepository.save(assetModel);
		return assetModel;
	}

	public AssetValueModel upsertAssetValue(AssetValueDTO assetValueDTO) {
		AssetValueModel assetValueModel = null;
		String assetValueId = assetValueDTO.getAssetValueId();
		if(StringUtils.isNotBlank(assetValueId)) {
			assetValueModel = assetValueRepository.findOne(assetValueId);
			if(assetValueModel != null) {
				List<FieldValueModel> fieldValueModelList = fieldValueRepository.findByAssetValueId(assetValueId);
				for(FieldValueModel fieldValueModel: fieldValueModelList) {
					for (FieldValueDTO fieldValueDTO : assetValueDTO.getFieldValues()) {
						if(fieldValueModel.getKey().equals(fieldValueDTO.getKey())) {							
							fieldValueModel.setValue(fieldValueDTO.getValue());
							fieldValueRepository.save(fieldValueModel);
						}
					}
				}
			}
		} else {
			assetValueModel = new AssetValueModel();
			assetValueModel.setType(assetValueDTO.getType());
			AssetValueModel createdAssetValueModel = assetValueRepository.save(assetValueModel);
			for (FieldValueDTO fieldValueDTO : assetValueDTO.getFieldValues()) {
				FieldValueModel fieldValueModel = new FieldValueModel();
				fieldValueModel.setKey(fieldValueDTO.getKey());
				fieldValueModel.setValue(fieldValueDTO.getValue());
				fieldValueModel.setAssetValueId(createdAssetValueModel.getId());
				fieldValueRepository.save(fieldValueModel);
			}
		}
		return assetValueModel;
	}

	public FieldModel newField(FieldModel fieldModel) {
		List<FieldModel> fieldModelList = fieldRepository.findByAssetIdAndName(fieldModel.getAssetId(),
				fieldModel.getName());
		if (!fieldModelList.isEmpty())
			throw new GenericGQLException("Field already present!", "ERR_ALREADY_EXIST");
		fieldRepository.save(fieldModel);
		return fieldModel;
	}

	public String deleteField(String fieldId) {
		fieldRepository.delete(fieldId);
		return String.format("%s deleted successfully!", fieldId);
	}

	public FieldValueModel newFieldValue(FieldValueDTO fieldValueDTO) {
		FieldValueModel fieldValueModel = new FieldValueModel();
		fieldValueModel.setKey(fieldValueDTO.getKey());
		fieldValueModel.setValue(fieldValueDTO.getValue());
		fieldValueRepository.save(fieldValueModel);
		return fieldValueModel;
	}

	public GenericDTO login(CredentialsBean credentials) {
		GenericDTO genericDTO = new GenericDTO();
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		System.out.println("Login Username" + username);
		UserModel userItem = userRepository.findByUsername(username);
		if (userItem == null) {
			genericDTO.setErrorCode("ERR_500");
			genericDTO.setErrorMessage("User does not exists!");
			return genericDTO;
		}
		String dbPassword = userItem.getPassword();
		if (!dbPassword.equalsIgnoreCase(password)) {
			genericDTO.setErrorCode("ERR_403");
			genericDTO.setErrorMessage("Incorrect Credentials!");
			return genericDTO;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (CommonUtils.checkAuthentication(authentication)) {
			System.out.println("Already Authenticated!" + authentication);
		} else {
			authentication = new UsernamePasswordAuthenticationToken(username, password, AUTHORITIES);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		System.out.println("httpSession" + httpSession.getId());
		httpSession.setAttribute(SPRING_SECURITY_CONTEXT, SecurityContextHolder.getContext());
		genericDTO.setToken(httpSession.getId());
		return genericDTO;
	}

	public GenericDTO signUp(UserModel userDetails) {
		GenericDTO genericDTO = new GenericDTO();
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		UserModel userItem = userRepository.findOne(username);
		if (userItem != null) {
			genericDTO.setErrorCode("ERR_500");
			genericDTO.setErrorMessage("Username already exists!");
			return genericDTO;
		}
		userRepository.save(userDetails);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (CommonUtils.checkAuthentication(authentication)) {
			System.out.println("Already Authenticated!" + authentication);
		} else {
			authentication = new UsernamePasswordAuthenticationToken(username, password, AUTHORITIES);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		System.out.println("httpSession" + httpSession.getId());
		httpSession.setAttribute(SPRING_SECURITY_CONTEXT, SecurityContextHolder.getContext());
		genericDTO.setToken(httpSession.getId());
		return genericDTO;
	}
}
