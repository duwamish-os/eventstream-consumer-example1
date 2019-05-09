package com.eventconsumer.schema;

import com.eventstream.events.BaseEvent;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Data
public class PageViewedEvent extends BaseEvent {

    public Long eventUuid;
    public String pageId;
    public String userId;

//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
//    )
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
