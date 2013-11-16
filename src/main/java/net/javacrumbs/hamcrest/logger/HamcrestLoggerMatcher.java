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

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Matcher wrapper that logs values being matched. Usage:
 *
 * <pre>
 *     assertThat("something", log(containsString("thing")));      // Checking that "something" is a string containing "thing"
 *     assertThat("something", log(not(containsString("hallo")))); // Checking that "something" is not a string containing "hallo"
 *
 *     assertThat(asList(1,2,3), hasItem(log(equalTo(2))));        // Checking that "1" is <2>
 *                                                                 // Checking that "2" is <2>
 *     assertThat(asList(1,2,3), log(hasItem(equalTo(2))));        // Checking that "[1, 2, 3]" is a collection containing <2>
 *
 * </pre>
 * @param <T>
 */
public class HamcrestLoggerMatcher<T> extends BaseMatcher<T> {
    private final Logger logger = LoggerFactory.getLogger(HamcrestLoggerMatcher.class);

    private final Matcher<T> matcher;
    private final String messageFormat;

    public HamcrestLoggerMatcher(Matcher<T> matcher) {
        this(matcher, "Checking that \"{}\" is {}");
    }

    public HamcrestLoggerMatcher(Matcher<T> matcher, String messageFormat) {
        this.matcher = matcher;
        this.messageFormat = messageFormat;
    }

    @Override
    public boolean matches(Object arg) {
        logger.info(messageFormat, convertToString(arg), matcher.toString());
        return matcher.matches(arg);
    }

    protected String convertToString(Object arg) {
        return String.valueOf(arg);
    }

    @Override
    public void describeTo(Description description) {
        matcher.describeTo(description);
    }

    @Override
    public String toString() {
        return matcher.toString();
    }

    @Factory
    public static <T> Matcher<T> log(Matcher<T> matcher) {
        return new HamcrestLoggerMatcher<T>(matcher);
    }
}
