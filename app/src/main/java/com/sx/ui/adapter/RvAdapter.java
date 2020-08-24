package com.sx.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sx.R;
import com.sx.model.CurrentWeather;

import java.util.List;

/***       Author  shy
 *         Time   2018/6/15 0015    16:39      */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final int EMPTY_VIEW = -1;      //没数据
    private final int PROGRESS_VIEW = -2;   //广告
    private final int IMAGE_VIEW = 1;       //正常数据
    private Context context;
    private List<CurrentWeather> weatherList;

    public RvAdapter(Context context, List<CurrentWeather> weatherList) {
        this.context = context;
        this.weatherList = weatherList;
    }

    @Override
    public int getItemViewType(int position) {
        if (weatherList.size() == 0) {
            return EMPTY_VIEW;  //空
        } else if (weatherList == null) {
            return EMPTY_VIEW;  //空
        } else if (position != 0 & position % 4 == 0) {
            return PROGRESS_VIEW;   //广告
        } else {
            return super.getItemViewType(position);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == EMPTY_VIEW) {
            view = LayoutInflater.from(context).inflate(R.layout.rv_item_empty, parent, false);
            view.setOnClickListener(this);
            MyEmptyVIewHolder holder = new MyEmptyVIewHolder(view);
            return holder;
        } else if (viewType == PROGRESS_VIEW) {
            view = LayoutInflater.from(context).inflate(R.layout.rv_item_advertisement, parent, false);
            view.setOnClickListener(this);
            MyTransparentViewHolder holder = new MyTransparentViewHolder(view);
            return holder;
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
            view.setOnClickListener(this);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                String date = weatherList.get(position).getDate();
                myViewHolder.tvRq.setText(date.substring(0,4) + "年" + date.substring(4,6) + "月" + date.substring(date.length()-2,date.length()));
                myViewHolder.tvWd.setText(weatherList.get(position).getTemperature());
                myViewHolder.tvWeather.setText(weatherList.get(position).getWeather());
                myViewHolder.tvWeek.setText(weatherList.get(position).getWeek());
                myViewHolder.tvWind.setText(weatherList.get(position).getWind());
                myViewHolder.itemView.setTag(position);

        } else if (holder instanceof MyEmptyVIewHolder) {

        } else if (holder instanceof MyTransparentViewHolder) {
            MyTransparentViewHolder myTransparentViewHolder = (MyTransparentViewHolder) holder;
            myTransparentViewHolder.llBj.getBackground().setAlpha(0);
            myTransparentViewHolder.itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvRq;
        TextView tvWd;
        TextView tvWeather;
        TextView tvWeek;
        TextView tvWind;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvRq = itemView.findViewById(R.id.tv_rq);
            tvWd = itemView.findViewById(R.id.tv_wd);
            tvWeather = itemView.findViewById(R.id.tv_weather);
            tvWeek = itemView.findViewById(R.id.tv_week);
            tvWind = itemView.findViewById(R.id.tv_wind);
        }
    }

    class MyEmptyVIewHolder extends RecyclerView.ViewHolder {

        public MyEmptyVIewHolder(View itemView) {
            super(itemView);

        }
    }

    class MyTransparentViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llBj;

        public MyTransparentViewHolder(View itemView) {
            super(itemView);
            llBj = itemView.findViewById(R.id.ll_item_t_bj);
        }
    }

    private OnItemClickListener mItemClickListener;
    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener!=null){
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    /**
     * 增加数据
     */

    public void addData(int position) {
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setDate("987987987987987987987");
        currentWeather.setTemperature("这是一条测试数据");
        weatherList.add(0,currentWeather);
        notifyItemInserted(position);//通知显示动画
        notifyItemRangeChanged(position,weatherList.size()-position);//通知数据与界面重新绑定
    }

    /**
     * 移除数据
     */

    public void removeData(int position) {
        weatherList.remove(position);
        notifyItemRemoved(position);//通知显示动画
        notifyItemRangeChanged(position,weatherList.size()-position);//通知数据与界面重新绑定
    }
}
