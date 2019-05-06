package com.eventconsumer.state;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.function.Supplier;

abstract class State {

    static Optional<Connection> connectionMaybe = db();

    public <A> Optional<A> safe(Supplier<A> fn) {
        try {
            return Optional.ofNullable(fn.get());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<Connection> db() {
        String url = "jdbc:postgresql://page-analytics-instances.???.us-west-2.rds.amazonaws.com/page_analytics_db" +
                "?user=root&password=?????????&ssl=false";

        try {
            return Optional.ofNullable(DriverManager.getConnection(url));
        } catch (Exception e) {
            System.out.println("Error getting connection" + e);
            return Optional.empty();
        }
    }

}
