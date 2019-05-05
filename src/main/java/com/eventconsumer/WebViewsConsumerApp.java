package com.eventconsumer;

public class WebViewsConsumerApp {

    public static void main(String[] args) {
        WebViewsConsumer.instance.consumeOnce();
        System.out.println("==============completed=============");
    }

}
