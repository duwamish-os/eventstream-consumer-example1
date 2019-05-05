package com.eventconsumer.schema;

import com.eventstream.events.BaseEvent;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

public class CampaignEvent extends BaseEvent {

    public CampaignEvent() {
    }

    @Getter
    @Setter
    public Long eventUuid;
    @Getter
    @Setter
    public String campaignId;
    @Getter
    @Setter
    public String userId;

//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
//    )
    @Getter
    @Setter
    public ZonedDateTime campaignDate;

    @Override
    public String getPartitionKey() {
        return campaignId + "-" + userId + "-" + campaignDate.toString();
    }

    @Override
    public Long getEventSourceId() {
        return eventUuid;
    }
}
