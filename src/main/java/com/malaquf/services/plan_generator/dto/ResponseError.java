package com.malaquf.services.plan_generator.dto;

import com.malaquf.services.plan_generator.error.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Response Error.
 */
public class ResponseError {

	/**
	 * Error code.
	 */
	private int code;
	/**
	 * Error message.
	 */
	private String message;
	
	/**
	 * Response Error.
	 * @param code error code. See {@link ErrorCode}.
	 * @param message The user readable message.
	 */
	public ResponseError(ErrorCode code, String message) {
		this.code = code.getValue();
		this.message= message;
	}
}
