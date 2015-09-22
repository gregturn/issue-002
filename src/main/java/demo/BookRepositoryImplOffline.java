/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO: To bring this solution online, rename withou the "Offline suffix.
 *
 * @author Greg Turnquist
 */
public class BookRepositoryImplOffline implements BookRepository {

  private final static Logger log = LoggerFactory.getLogger(BookRepositoryImplOffline.class);

  private AtomicLong bookCounter = new AtomicLong(0L);

  private Map<Long, Book> books = new HashMap<>();

  @Override
  public Book save(Book entity) {

    log.debug("Saving book " + entity.getTitle());
    entity.setId(bookCounter.incrementAndGet());
    this.books.put(entity.getId(), entity);
    return this.books.get(entity.getId());
  }

  @Override
  public <S extends Book> Iterable<S> save(Iterable<S> entities) {

    log.debug("Saving iterable list of books");
    List<S> savedBooks = new ArrayList<>();
    for (S entity : entities) {
      entity.setId(bookCounter.incrementAndGet());
      this.books.put(entity.getId(), entity);
      savedBooks.add(entity);
    }
    return savedBooks;
  }

  @Override
  public Book findOne(Long aLong) {

    log.debug("Saving book " + aLong);
    return this.books.get(aLong);
  }

  @Override
  public boolean exists(Long aLong) {

    log.debug("Does " + aLong + " exist?");
    return this.books.containsKey(aLong);
  }

  @Override
  public Iterable<Book> findAll() {

    log.debug("Finding all books");
    return this.books.values();
  }

  @Override
  public Iterable<Book> findAll(Iterable<Long> longs) {

    log.debug("Finding all books from a subset");
    List<Book> books = new ArrayList<>();
    for (Long id : longs) {
      for (Book book : this.books.values()) {
        if (book.getId() == id) {
          books.add(book);
        }
      }
    }
    return books;
  }

  @Override
  public long count() {

    log.debug("Counting books");
    return this.books.size();
  }

  @Override
  public void delete(Long aLong) {

    log.debug("Deleting book " + aLong);
    this.books.remove(aLong);
  }

  @Override
  public void delete(Book entity) {

    log.debug("Deleting book " + entity.getTitle());
    this.books.remove(entity.getId());

  }

  @Override
  public void delete(Iterable<? extends Book> entities) {

    log.debug("Deleting iterable list of books.");
    for (Book book : entities) {
      this.books.remove(book.getId());
    }
  }

  @Override
  public void deleteAll() {

    log.debug("Deleting all books.");
    this.books = new HashMap<>();
  }

  @Override
  public Book findByUserUsernameAndId(@Param("username") String username, @Param("id") Long id) {
    return null;
  }
}
