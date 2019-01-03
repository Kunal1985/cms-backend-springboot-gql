package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.exception.GraphQLErrorAdapter;
import com.app.repository.AssetRepository;
import com.app.repository.AssetValueRepository;
import com.app.repository.FieldRepository;
import com.app.repository.FieldValueRepository;
import com.app.repository.UserRepository;
import com.app.resolver.AssetResolver;
import com.app.resolver.AssetValueResolver;
import com.app.resolver.Mutation;
import com.app.resolver.Query;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@SpringBootApplication
public class CMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CMSApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream().filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream().filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new).collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public AssetResolver assetResolver(FieldRepository fieldRepository) {
		return new AssetResolver(fieldRepository);
	}

	@Bean
	public AssetValueResolver assetValueResolver(FieldRepository fieldRepository,
			FieldValueRepository fieldValueRepository) {
		return new AssetValueResolver(fieldRepository, fieldValueRepository);
	}

	@Bean
	public Query query(AssetRepository assetRepository, AssetValueRepository assetValueRepository,
			FieldRepository fieldRepository, FieldValueRepository fieldValueRepository, UserRepository userRepository) {
		return new Query(assetRepository, assetValueRepository, fieldRepository, fieldValueRepository, userRepository);
	}

	@Bean
	public Mutation mutation(AssetRepository assetRepository, AssetValueRepository assetValueRepository,
			FieldRepository fieldRepository, FieldValueRepository fieldValueRepository, UserRepository userRepository) {
		return new Mutation(assetRepository, assetValueRepository, fieldRepository, fieldValueRepository,
				userRepository);
	}

	@Bean
	public CommandLineRunner demo(AssetRepository assetRepository, AssetValueRepository assetValueRepository,
			FieldRepository fieldRepository, FieldValueRepository fieldValueRepository, UserRepository userRepository) {
		return (args) -> {
			// TODO: Initial values
			System.out.println("CommandLine");
		};
	}
}
