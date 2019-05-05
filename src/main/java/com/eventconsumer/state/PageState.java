package com.eventconsumer.state;

import lombok.Getter;
import lombok.Setter;

public class PageState {

    @Getter
    @Setter
    public String pageId;

    @Getter
    @Setter
    public Long views;
}
