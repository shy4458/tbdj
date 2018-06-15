package com.sx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/***       Author  shy
 *         Time   2018/6/15 0015    16:39      */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private Context context;
    private TqBean bean;

    public RvAdapter(Context context, TqBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTq.setText(bean.getResult().getFuture().getDay_20180615().getTemperature());
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTq;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTq = itemView.findViewById(R.id.tv_tq);
        }
    }

}
