package com.ds.thapovan.expandable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ds.thapovan.R;
import com.ds.thapovan.expandable_response.LevelsItem;
import com.ds.thapovan.expandable_response.StagesItem;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<ExpandableAdapter.HeaderViewHolder, ExpandableAdapter.ExpandableChild> {

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public HeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_list_title, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public ExpandableChild onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_list_item, parent, false);
        return new ExpandableChild(view);
    }

    @Override
    public void onBindChildViewHolder(ExpandableChild holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final LevelsItem artist = ((ExpandableItem) group).getItems().get(childIndex);

        holder.leveltitle.setText(artist.getLevelName());
    }

    @Override
    public void onBindGroupViewHolder(HeaderViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setHeaderItem(group);
    }

    public class ExpandableChild extends ChildViewHolder {

        @BindView(R.id.el_item)TextView leveltitle;

        public ExpandableChild(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setChildItem() {

        }
    }
    public class HeaderViewHolder extends GroupViewHolder {
        @BindView(R.id.el_title)TextView stagetitle;


        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        public void setHeaderItem(ExpandableGroup group) {
            stagetitle.setText(group.getTitle());
        }
    }
}
