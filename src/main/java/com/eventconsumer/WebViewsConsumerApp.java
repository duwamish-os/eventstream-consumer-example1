package com.eventconsumer;

public class WebViewsConsumerApp {

    public static void main(String[] args) {
        System.out.println("==============start consumer=============");
        WebViewsConsumer.consumer.consume();
        System.out.println("==============consumer completed=============");
    }

}
