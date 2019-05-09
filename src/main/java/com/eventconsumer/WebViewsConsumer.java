package com.eventconsumer;

import com.eventconsumer.schema.CampaignEvent;
import com.eventconsumer.schema.ImpressionSentEvent;
import com.eventconsumer.schema.PageViewedEvent;
import com.eventconsumer.state.ImpressionState;
import com.eventconsumer.state.PageState;
import com.eventstream.consumer.EventConsumerFactory;
import com.eventstream.consumer.MultiEventStreamConsumer;
import com.eventstream.consumer.dispatcher.MultiEventHandler;
import lombok.val;
import org.json.JSONObject;

public class WebViewsConsumer {

    public static MultiEventStreamConsumer consumer =
            new EventConsumerFactory().create("Pipeline1Stream");

    static {
        consumer.setEventSourceIdLambda(event -> new JSONObject(event).getLong("eventUuid"))
                .setEventTypeLambda(event -> new JSONObject(event).getString("eventType"))
                .setEventHandler(new WebViewsHandler());
    }

    //note: the Handler class has to be public/ not just method
    public static class WebViewsHandler extends MultiEventHandler {

        public void onEvent(CampaignEvent campaignEvent) {
            System.out.println("=======================");
            System.out.println(campaignEvent);
            System.out.println("=======================");
        }

        public void onEvent(PageViewedEvent pageViewedEvent) {
            PageState pageState = new PageState();
            pageState.apply(pageViewedEvent);
            System.out.println("new state is " + pageState.views);
        }

    }

}
