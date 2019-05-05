package com.eventconsumer.schema;

import com.eventstream.events.BaseEvent;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class PageViewedEvent extends BaseEvent {

    public PageViewedEvent() {
    }

    private Long eventUuid;
    private String pageId;
    private String userId;

//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
//    )
    private ZonedDateTime pageViewedDate;

    @Override
    public String getPartitionKey() {
        return pageId + "-" + userId + "-" + pageViewedDate.toString();
    }

    @Override
    public Long getEventSourceId() {
        return eventUuid;
    }

    public Long getEventUuid() {
        return eventUuid;
    }

    public void setEventUuid(Long eventUuid) {
        this.eventUuid = eventUuid;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ZonedDateTime getPageViewedDate() {
        return pageViewedDate;
    }

    public void setPageViewedDate(ZonedDateTime pageViewedDate) {
        this.pageViewedDate = pageViewedDate;
    }
}
