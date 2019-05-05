package com.eventconsumer.schema;

import com.eventstream.events.BaseEvent;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class CampaignEvent extends BaseEvent {

    public CampaignEvent() {
    }

    private Long eventUuid;
    private String campaignId;
    private String userId;

//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
//    )
    private ZonedDateTime campaignDate;

    @Override
    public String getPartitionKey() {
        return campaignId + "-" + userId + "-" + campaignDate.toString();
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ZonedDateTime getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(ZonedDateTime campaignDate) {
        this.campaignDate = campaignDate;
    }
}
