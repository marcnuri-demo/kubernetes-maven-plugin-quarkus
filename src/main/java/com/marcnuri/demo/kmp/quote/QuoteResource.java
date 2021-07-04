package com.marcnuri.demo.kmp.quote;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quotes")
public class QuoteResource {

  private static final String HEADER_QUOTE_AUTHOR = "Quote-Author";

  private QuoteService quoteService;

  @GET
  @Path("/random")
  @Produces(MediaType.TEXT_PLAIN)
  public Response getRandomQuote() {
    final var randomQuote = quoteService.getRandomQuote();
    return Response
      .ok(randomQuote.getContent(), MediaType.TEXT_PLAIN_TYPE)
      .header(HEADER_QUOTE_AUTHOR, randomQuote.getAuthor())
      .build();
  }

  @Inject
  public void setQuoteService(QuoteService quoteService) {
    this.quoteService = quoteService;
  }
}