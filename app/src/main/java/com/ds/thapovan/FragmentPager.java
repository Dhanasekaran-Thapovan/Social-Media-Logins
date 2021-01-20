package com.ds.thapovan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ds.thapovan.expandable.FragmentExpandableView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentPager extends Fragment {

    @BindView(R.id.vw_pager)
    ViewPager vwPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        setPager();


    }

    private void setPager() {
        vwPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        new FragmentProfile();

                        break;
                    case 1:
                        new FragmentProfile();

                        break;
                    case 2:
                        new FragmentProfile();
                        break;
                    case 3:
                        new FragmentProfile();

                        break;
                }
                return new FragmentProfile();
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }
}
