/*
 * Quote.java
 *
 * Created on 2021-07-04, 6:47
 */
package com.marcnuri.demo.kmp.quote;

import java.io.Serializable;
import java.util.Objects;

public class Quote implements Serializable {

  private static final long serialVersionUID = 6301596552055083396L;

  private String content;
  private String author;

  String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Quote quote = (Quote) o;
    return Objects.equals(content, quote.content) && Objects.equals(author, quote.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, author);
  }
}
