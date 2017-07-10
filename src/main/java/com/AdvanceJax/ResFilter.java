package com.AdvanceJax;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

//@Provider
public class ResFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext reqCon) throws IOException {
		
		System.out.println("Request Filter: ");
		System.out.println("Headers : " +reqCon.getHeaders());	
		
	}

	@Override
	public void filter(ContainerRequestContext reqCon, ContainerResponseContext resCon) throws IOException {
		
		System.out.println("Response Filter: ");
		System.out.println("Headers : "+resCon.getHeaders());
		
	}

}
