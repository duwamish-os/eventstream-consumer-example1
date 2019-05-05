package com.eventconsumer;

import com.eventconsumer.schema.CampaignEvent;
import com.eventconsumer.schema.PageViewedEvent;
import com.eventstream.consumer.dispatcher.MultiEventHandler;
import com.eventstream.consumer.kinesis.KinesisEventStreamConsumer;
import org.json.JSONObject;

public class CampaignConsumer extends KinesisEventStreamConsumer {

    public class CampaignHandler extends MultiEventHandler {
        public void onEvent(CampaignEvent campaignEvent) {
            System.out.println("=======================");
            System.out.println(campaignEvent);
            System.out.println("=======================");
        }

        public void onEvent(PageViewedEvent pageViewedEvent) {
            System.out.println("=======================");
            System.out.println(pageViewedEvent);
            System.out.println("=======================");
        }
    }

    public CampaignConsumer() {
        //FIXME stream from config
        this("Pipeline1Stream");
    }

    //note: the Handler class has to be public/ not just method
    public CampaignConsumer(String stream) {
        super(stream);
        this.setEventSourceIdLambda(event -> new JSONObject(event).getLong("eventUuid"))
                .setEventTypeLambda(event ->
                        new JSONObject(event).getString("eventType"))
                .setEventHandler(new CampaignHandler());
    }

    public static CampaignConsumer instance = new CampaignConsumer();
}
