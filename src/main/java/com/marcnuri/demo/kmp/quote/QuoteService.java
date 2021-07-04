/*
 * QuoteService.java
 *
 * Created on 2021-07-04, 6:51
 */
package com.marcnuri.demo.kmp.quote;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class QuoteService {

  private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

  private static final String QUOTES_RESOURCE= "/quotes/quotes.json";

  private final List<Quote> quotes;

  public QuoteService() {
    quotes = new ArrayList<>();
  }

  @PostConstruct
  protected final void initialize() {
    final var objectMapper = new ObjectMapper();
    try (final InputStream quotesStream = QuoteService.class.getResourceAsStream(QUOTES_RESOURCE)) {
      quotes.addAll(objectMapper.readValue(quotesStream,
        objectMapper.getTypeFactory().constructCollectionType(List.class, Quote.class)));
    } catch (IOException e) {
      log.error("Error loading quotes", e);
    }
  }


  Quote getRandomQuote() {
    return quotes.get(ThreadLocalRandom.current().nextInt(quotes.size()));
  }
}
