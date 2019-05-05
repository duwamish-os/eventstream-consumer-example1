package com.eventconsumer;

public class CampaignConsumerApp {

    public static void main(String[] args) {
        CampaignConsumer.instance.consumeOnce();
        System.out.println("==============completed=============");
    }

}
