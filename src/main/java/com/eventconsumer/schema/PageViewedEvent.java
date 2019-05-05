package com.eventconsumer.schema;

import com.eventstream.events.BaseEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

public class PageViewedEvent extends BaseEvent {

    public PageViewedEvent() {
    }

    @Getter
    @Setter
    public Long eventUuid;
    @Getter
    @Setter
    public String pageId;
    @Getter
    @Setter
    public String userId;

//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
//    )
    @Getter
    @Setter
    public ZonedDateTime pageViewedDate;

    @Override
    public String getPartitionKey() {
        return pageId + "-" + userId + "-" + pageViewedDate.toString();
    }

    @Override
    public Long getEventSourceId() {
        return eventUuid;
    }

}
