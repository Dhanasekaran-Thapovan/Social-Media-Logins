package com.ds.thapovan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ds.thapovan.api_respose.DataItem;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmpRecAdapter extends RecyclerView.Adapter<EmpRecAdapter.EmpRecViewHolder> {
    private List<DataItem> empList;

    public EmpRecAdapter(List<DataItem> empList) {
            this.empList=empList;
    }

    @NonNull
    @Override
    public EmpRecAdapter.EmpRecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_model, parent, false);
        return new EmpRecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpRecAdapter.EmpRecViewHolder holder, int position) {
        holder.ename.setText(empList.get(position).getEmployeeName());
        holder.eage.setText(empList.get(position).getEmployeeAge());
        holder.eid.setText(empList.get(position).getId());
        holder.esal.setText(empList.get(position).getEmployeeSalary());
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public static class EmpRecViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_name) TextView ename;
        @BindView(R.id.list_age) TextView eage;
        @BindView(R.id.list_id) TextView eid;
        @BindView(R.id.list_sal) TextView esal;

        public EmpRecViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
