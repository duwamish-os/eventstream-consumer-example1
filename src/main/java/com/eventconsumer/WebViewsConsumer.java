package com.eventconsumer;

import com.eventconsumer.schema.CampaignEvent;
import com.eventconsumer.schema.PageViewedEvent;
import com.eventconsumer.state.PageState;
import com.eventstream.consumer.dispatcher.MultiEventHandler;
import com.eventstream.consumer.kinesis.KinesisEventStreamConsumer;
import lombok.val;
import org.json.JSONObject;

public class WebViewsConsumer extends KinesisEventStreamConsumer {

    public class WebViewsHandler extends MultiEventHandler {

        public void onEvent(CampaignEvent campaignEvent) {
            System.out.println("=======================");
            System.out.println(campaignEvent);
            System.out.println("=======================");
        }

        public void onEvent(PageViewedEvent pageViewedEvent) {
            val pageState = new PageState();
            pageState.apply(pageViewedEvent);
            System.out.println("new state is " + pageState.views);
        }
        
    }

    public WebViewsConsumer() {
        //FIXME stream from config
        this("Pipeline1Stream");
    }

    //note: the Handler class has to be public/ not just method
    public WebViewsConsumer(String stream) {
        super(stream);
        this.setEventSourceIdLambda(event -> new JSONObject(event).getLong("eventUuid"))
                .setEventTypeLambda(event ->
                        new JSONObject(event).getString("eventType"))
                .setEventHandler(new WebViewsHandler());
    }

    public static WebViewsConsumer instance = new WebViewsConsumer();
}
