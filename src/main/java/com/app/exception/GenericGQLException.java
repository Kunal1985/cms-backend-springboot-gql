package com.app.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class GenericGQLException extends RuntimeException implements GraphQLError {
	private static final long serialVersionUID = -2825346741037881657L;
	private Map<String, Object> extensions = new HashMap<>();

	public GenericGQLException(String errorMessage, String errorCode) {
		super(errorMessage);
		extensions.put("GenericGQLException", errorCode);
	}

	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}

}
