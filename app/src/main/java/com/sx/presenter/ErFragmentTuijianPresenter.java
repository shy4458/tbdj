package com.sx.presenter;

import com.google.gson.Gson;
import com.sx.model.erFragmentModel.RecommendBean;
import com.sx.ui.fragment.erFragment.ErFragmentContent;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ErFragmentTuijianPresenter extends BasePresenter{

    ErFragmentContent fragmentContent;

    public ErFragmentTuijianPresenter(ErFragmentContent fragmentContent) {
        this.fragmentContent = fragmentContent;
    }

    public void video(){
        Call<ResponseBody> video = retrofit2Service.video();
        video.enqueue(new CallbackAdapter());
    }

    @Override
    protected void failed(String msg) {

    }

    @Override
    protected void parserData(String data) {
        RecommendBean recommendBean = new Gson().fromJson(data, RecommendBean.class);
        fragmentContent.getDate(recommendBean);
    }
}
