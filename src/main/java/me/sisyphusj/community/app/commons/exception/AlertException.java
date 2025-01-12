package me.sisyphusj.community.app.commons.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.sisyphusj.community.app.commons.LocationUrl;

@Builder
@Getter
@AllArgsConstructor
public class AlertException extends RuntimeException {

	private final HttpStatus status;

	private final String message;

	private final LocationUrl locationUrl;

	public static AlertException of500(String message, LocationUrl locationUrl) {
		return AlertException.builder()
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.message(message)
			.locationUrl(locationUrl)
			.build();
	}

	public static AlertException of400(String message, LocationUrl locationUrl) {
		return AlertException.builder()
			.status(HttpStatus.BAD_REQUEST)
			.message(message)
			.locationUrl(locationUrl)
			.build();
	}

}
