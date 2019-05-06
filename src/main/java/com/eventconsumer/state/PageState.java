package com.eventconsumer.state;

import com.eventconsumer.schema.PageViewedEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.sql.*;
import java.util.Optional;
import java.util.function.Supplier;

public class PageState extends State {

    @Getter
    @Setter
    public String pageId;

    @Getter
    @Setter
    public Long views = 0L;

    /**
     * type unsafe method to insert
     */
    public Optional<PageState> apply(PageViewedEvent pageViewedEvent) {
        pageId = pageViewedEvent.pageId;
        views = views + 1;

        Optional<PageState> state = connectionMaybe.flatMap(connection -> {
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO page_views(page_id, page_views, event_history) VALUES(?, ?, ?::json)");
                statement.setString(1, pageId);
                statement.setLong(2, views);
                statement.setString(3, pageViewedEvent.toJSON(pageViewedEvent));
                statement.execute();
                statement.close();
                return Optional.of(this);
            } catch (SQLException e) {
                System.out.println("error updating state: "+ e);
                e.printStackTrace();
                return empty();
            } finally {
                System.out.println("finally");
            }
        });

        return state;
    }

    public Optional<PageState> empty() {
        return Optional.empty();
    }

    public static void main(String[] args) {

        PageViewedEvent pageViewedEvent = new PageViewedEvent();
        pageViewedEvent.eventUuid = 1L;
        pageViewedEvent.pageId = "";

        val result = new PageState().apply(pageViewedEvent);

        connectionMaybe.ifPresent(connection -> {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(*) from page_views");

                while (resultSet.next()) {
                    System.out.println(resultSet.getLong("count"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
