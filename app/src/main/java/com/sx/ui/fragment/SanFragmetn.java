package com.sx.ui.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sx.BuildConfig;
import com.sx.R;
import com.sx.dagger.component.DaggerSanComponent;
import com.sx.dagger.module.SanModule;
import com.sx.presenter.SanPresenter;
import com.sx.ui.activity.aaActivity;

import javax.inject.Inject;

/***       Author  shy
 *         Time   2018/6/21 0021    16:59      */

public class SanFragmetn extends BaseFragment {


    @Inject
    SanPresenter presenter;
    private TextView tv;
    private Button b;

    @Override
    protected void initDagger() {
        DaggerSanComponent.builder().sanModule(new SanModule(this)).build().in(this);
    }

    @Override
    public int intiLayout() {
        return R.layout.fragment_san;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        tv = view.findViewById(R.id.tv);
        b = view.findViewById(R.id.b);

        final NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        final Notification.Builder builder = new Notification.Builder(getActivity().getApplicationContext())
                .setSmallIcon(R.mipmap.ic_app)
                .setTicker("状态栏标题")
                .setContentText("内容")
                .setContentTitle("标题");

        Intent intent = new Intent(getActivity(), aaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("798", "456");
        final PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 5, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //8.0需要channel
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    final String channelID = "1";
                    String channelName = "shy";
                    final NotificationChannel notificationChannel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
                    notificationManager.createNotificationChannel(notificationChannel);
                    builder.setChannelId(channelID);
                }
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(1, builder.build());
            }
        });
    }

    @Override
    public void initData() {
        presenter.tab();
    }

    public void lx(String data) {
        tv.setText(data);
    }
}
