package io.github.learnjava11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class HttpClientTests {

	@Test
	@Disabled("Integration test")
	public void testInvokingHttpClient() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10)).build();

		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://httpbin.org/get"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot")
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		assertEquals(200, response.statusCode());

		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println(response.body());
	}

}
