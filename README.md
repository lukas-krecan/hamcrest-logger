Hamcrest logger
===============

[Hamcrest](https://github.com/hamcrest/JavaHamcrest) does a really great job when it comes to error logging. But sometimes you get to situations, where Hamcrest 
matchers are used in other contexts, and the error messages are not so good. If you are in such situation, 
Hamcrest logger is here for you. It's basically just a wrapper around other matchers which logs values to be 
compared. And that's it, just one class that logs parameters.

To use it, here is what you need to do.

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
