package com.sx.presenter;

import android.util.Log;

import com.sx.ui.fragment.SanFragmetn;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class SanPresenter extends BasePresenter {

    private SanFragmetn fragmetn;

    public SanPresenter(SanFragmetn fragmetn) {
        this.fragmetn = fragmetn;
    }

    @Override
    protected void failed(String msg) {

    }

    @Override
    protected void parserData(String data) {
        fragmetn.lx(data);
    }

    public void tab(){
        Call<ResponseBody> lx = retrofit2Service.lx("1", "1", "1");
        lx.enqueue(new CallbackAdapter());
    }

}
