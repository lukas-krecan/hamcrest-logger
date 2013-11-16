/**
 * Copyright 2009-2013 the original author or authors.
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
package net.javacrumbs.hamcrest.logger;

import org.junit.Test;

import static java.util.Arrays.asList;
import static net.javacrumbs.hamcrest.logger.HamcrestLoggerMatcher.log;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestLoggerMatcherTest {

    @Test
    public void logOk() {
        assertThat("something", log(containsString("thing")));
        assertThat("something", log(not(containsString("hallo"))));
    }

    @Test
    public void logCollection() {
        assertThat(asList(1,2,3), hasItem(log(equalTo(2))));
        assertThat(asList(1,2,3), log(hasItem(equalTo(2))));
    }


}
