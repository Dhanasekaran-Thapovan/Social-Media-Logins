package com.ds.thapovan.expandable;

import com.ds.thapovan.expandable_response.LevelsItem;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ExpandableItem extends ExpandableGroup<LevelsItem> {
    String title;
    List<LevelsItem> item;

    public ExpandableItem(String title, List<LevelsItem> items) {
        super(title, items);
        this.title=title;
        this.item=items;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LevelsItem> getItem() {
        return item;
    }

    public void setItem(List<LevelsItem> item) {
        this.item = item;
    }
}
