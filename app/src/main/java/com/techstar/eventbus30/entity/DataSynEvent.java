package com.techstar.eventbus30.entity;

/**
 * author lrzg on 16/12/7.
 * 描述：点赞数量
 */

public class DataSynEvent {
    public DataSynEvent(int count) {
        this.count = count;
    }

    public int count;
}
