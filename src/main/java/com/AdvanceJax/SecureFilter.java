package com.AdvanceJax;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.codec.binary.Base64;



@Provider
public class SecureFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext reqCon) throws IOException {

		if (reqCon.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {

			List<String> authHeader = reqCon.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {

				String authToken = authHeader.get(0);

				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				//String decodedString = Base64.decodeAsString(authToken);
				byte[] decoded =Base64.decodeBase64(authToken);
				String decodedString = new String(decoded, "UTF-8");
				//System.out.println("DecodedString:"+authToken);

				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");

				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				if ("user".equals(username) && "password".equals(password)) {
					return;
				}
			}

			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource").build();

			reqCon.abortWith(unauthorizedStatus);

		}
	}
}
