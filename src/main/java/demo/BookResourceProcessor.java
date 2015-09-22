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

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
@Component
public class BookResourceProcessor implements ResourceProcessor<Resources<Resource<Book>>> {

  @Override
  public Resources<Resource<Book>> process(Resources<Resource<Book>> resource) {
    resource.add(new Link("/users/{username}/books/{id}").withRel("findByUserUsernameAndId"));
    return resource;
  }

}
