package com.mdevino.shiny.timebox.scalar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jetbrains.annotations.NotNull;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

public class LocalDateTimeScalar {

	public static final GraphQLScalarType LOCALDATETIME = GraphQLScalarType.newScalar().name("LocalDateTime")
			.description("LocalDateTime scalar").coercing(new Coercing<String, LocalDateTime>() {
				@Override
				public LocalDateTime serialize(Object dataFetcherResult) {
					return serializeLocalDateTime(dataFetcherResult);
				}

				@Override
				public @NotNull String parseValue(Object input) {
					return parseLocalDateTimeFromVariable(input);
				}

				@Override
				public @NotNull String parseLiteral(Object input) {
					return parseLocalDateTimeFromAstLiteral(input);
				}

			}).build();

	private static LocalDateTime serializeLocalDateTime(Object dataFetcherResult) {
		String possibleEmailValue = String.valueOf(dataFetcherResult);
		try {
			String inputString = (String) (dataFetcherResult);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return LocalDateTime.parse(inputString, formatter);
		} catch (Exception e) {
			throw new CoercingSerializeException("Unable to serialize " + possibleEmailValue + " as a LocalDateTime");
		}
	}

	private static String parseLocalDateTimeFromVariable(Object input) {
		try {
			String inputString = (String) (input);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return inputString;
		} catch (Exception e) {
			throw new CoercingParseValueException("Unable to parse variable value " + input + " as a LocalDateTime");
		}
	}

	private static String parseLocalDateTimeFromAstLiteral(Object input) {
		if (input instanceof StringValue) {
			try {
				String inputString = (String) (input);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				return inputString;
			} catch (Exception e) {
				throw new CoercingParseValueException("Value is not a LocalDateTime: '" + String.valueOf(input) + "'");
			}
		}
		throw new CoercingParseLiteralException("Value is not a LocalDateTime: '" + String.valueOf(input) + "'");
	}

}
