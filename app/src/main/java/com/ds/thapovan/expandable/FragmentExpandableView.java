package com.ds.thapovan.expandable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ds.thapovan.R;
import com.ds.thapovan.api.apiutils.CommunicationManager;
import com.ds.thapovan.api.subscriber.ExpandableEventSubscriber;
import com.ds.thapovan.expandable_response.ExpandableApiResponse;
import com.ds.thapovan.expandable_response.StagesItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentExpandableView extends Fragment implements ExpandableEventSubscriber {


    @BindView(R.id.expand_rec_view)
    RecyclerView ex_rec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expandable, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        CommunicationManager.getInstance().getExpandableDetails(this);

    }


    public void onExpandableResponse(ExpandableApiResponse response) {
        if (response.isSuccess()) {
            List<StagesItem> parser = response.getDatas().getRecoveryOptions().getStages();
            List<ExpandableItem> list=new ArrayList<>();
            for (StagesItem item :parser) {
                list.add(new ExpandableItem(item.getStageName(),item.getLevels()));
            }
            ex_rec.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            ExpandableAdapter adapter = new ExpandableAdapter(list);

            ex_rec.setAdapter(adapter);
        }
    }
}
