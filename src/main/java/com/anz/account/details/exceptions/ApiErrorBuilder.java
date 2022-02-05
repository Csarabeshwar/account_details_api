package com.anz.account.details.exceptions;

import com.anz.account.details.model.ApiError;

public class ApiErrorBuilder {
	public static ApiError buildErrorResponse(ApiError errorResponse) {
		return ApiError.builder().errorId(errorResponse.getErrorId()).httpStatus(errorResponse.getHttpStatus())
				.message(errorResponse.getMessage()).build();
	}
}
