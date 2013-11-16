Hamcrest logger
===============

Do you wonder why your Hamcrest-based test is failing? Do you fight with a matcher extension that does not log well?
Fight no more. Hamcrest logger is here to help you.

Just add log matcher and it will log all you need

    import static net.javacrumbs.hamcrest.logger.HamcrestLoggerMatcher.log;

    ...
    //Logs: Checking that "something" is a string containing "thing"
    assertThat("something", log(containsString("thing")));

    //Logs: Checking that "something" is not a string containing "hallo"
    assertThat("something", log(not(containsString("hallo"))));


    //Logs: Checking that "1" is <2>
    //      Checking that "2" is <2>
    assertThat(asList(1,2,3), hasItem(log(equalTo(2))));

    // Logs: Checking that "[1, 2, 3]" is a collection containing <2>
    assertThat(asList(1,2,3), log(hasItem(equalTo(2))));


Uses [SLF4J](http://www.slf4j.org/) log abstraction.


## Maven

    <dependency>
        <groupId>net.javacrumbs.hamcrest-logger</groupId>
        <artifactId>hamcrest-logger</artifactId>
        <version>0.0.1</version>
        <scope>test</scope>
    </dependency>