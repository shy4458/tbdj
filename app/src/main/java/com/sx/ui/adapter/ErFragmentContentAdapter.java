package com.sx.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sx.R;
import com.sx.model.erFragmentModel.RecommendBean;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class ErFragmentContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private RecommendBean recommendBean;

    public ErFragmentContentAdapter(Context context, RecommendBean recommendBean) {
        this.context = context;
        this.recommendBean = recommendBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.er_fragment_rv_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder)holder;
//        viewHolder.ivTouxiang.
        Picasso.with(context).load("http://192.168.120.220:8011/readPic?imgName=" +
        recommendBean.getVideoList().get(position).getPic() +".jpg").into(viewHolder.ivTouxiang);
        viewHolder.jz.setUp("http://192.168.120.220:8011/readVideo?videoName="+recommendBean.getVideoList().get(position).getUrl() + ".mp4",JZVideoPlayer.SCREEN_WINDOW_LIST,recommendBean.getVideoList().get(position).getName());
        viewHolder.tvLeixing.setText(recommendBean.getVideoList().get(position).getName());
        viewHolder.tvBiaoqian.setText(recommendBean.getVideoList().get(position).getTitle());
        viewHolder.tvZan.setText(recommendBean.getVideoList().get(position).getZan());
        viewHolder.tvPinglun.setText(recommendBean.getVideoList().get(position).getPinglun());

    }

    @Override
    public int getItemCount() {
        return recommendBean.getVideoList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        JZVideoPlayerStandard jz;
        ImageView ivTouxiang;
        TextView tvLeixing;
        TextView tvBiaoqian;
        TextView tvZan;
        TextView tvPinglun;
        ImageView ivGengduo;

        public MyViewHolder(View itemView) {
            super(itemView);
            jz = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_jz);
            ivTouxiang = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_touxiang);
            tvLeixing = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_leixing);
            tvBiaoqian = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_biaoqian);
            tvZan = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_zan);
            tvPinglun = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_pinglun);
            ivGengduo = itemView.findViewById(R.id.er_fragment_tuijian_rv_item_gengduo);

        }
    }
}
