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

/**
 * @author Greg Turnquist
 */
public class BookRepositoryImpl implements BookRepository {

  private final static Logger log = LoggerFactory.getLogger(BookRepositoryImpl.class);

  @Override
  public Book save(Book entity) {
    log.debug("Saving book " + entity.getTitle());
    return null;
  }

  @Override
  public <S extends Book> Iterable<S> save(Iterable<S> entities) {
    log.debug("Saving iterable list of books");
    return null;
  }

  @Override
  public Book findOne(Long aLong) {
    log.debug("Saving book " + aLong);
    return null;
  }

  @Override
  public boolean exists(Long aLong) {
    log.debug("Does " + aLong + " exist?");
    return false;
  }

  @Override
  public Iterable<Book> findAll() {
    log.debug("Finding all books");
    return null;
  }

  @Override
  public Iterable<Book> findAll(Iterable<Long> longs) {
    log.debug("Finding all books from a subset");
    return null;
  }

  @Override
  public long count() {
    log.debug("Counting books");
    return 0;
  }

  @Override
  public void delete(Long aLong) {
    log.debug("Deleting book " + aLong);

  }

  @Override
  public void delete(Book entity) {
    log.debug("Deleting book " + entity.getTitle());

  }

  @Override
  public void delete(Iterable<? extends Book> entities) {
    log.debug("Deleting iterable list of books.");

  }

  @Override
  public void deleteAll() {
    log.debug("Deleting all books.");

  }
}
