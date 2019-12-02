package com.hackthon.kisainsur.src.guest;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.BaseActivity;


import java.util.List;

import kr.co.bootpay.Bootpay;
import kr.co.bootpay.BootpayAnalytics;
import kr.co.bootpay.CancelListener;
import kr.co.bootpay.CloseListener;
import kr.co.bootpay.ConfirmListener;
import kr.co.bootpay.DoneListener;
import kr.co.bootpay.ErrorListener;
import kr.co.bootpay.ReadyListener;
import kr.co.bootpay.enums.Method;
import kr.co.bootpay.enums.PG;


public class GuestThankActivity extends BaseActivity {

    TextView mTextViewMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_thank);
        mTextViewMoney = findViewById(R.id.activity_guest_thank_tv_money);

        BootpayAnalytics.init(this, "5de1815f0627a8002487caf0");


        mTextViewMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getPackageList()){
                    Intent intent = getPackageManager().getLaunchIntentForPackage("viva.republica.toss");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else{
                    String url = "market://details?id=" + "viva.republica.toss";
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }

//                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
//                Intent existPackage = getPackageManager().getLaunchIntentForPackage(intent.getPackage());
//                if (existPackage != null)
//                    startActivity(intent);
            }
        });
//        BootpayAnalytics.init(this, application_id);
//        Bootpay.useOnestoreApi(this);


    }


    public boolean getPackageList() {
        boolean isExist = false;

        PackageManager pkgMgr = getPackageManager();
        List<ResolveInfo> mApps;
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mApps = pkgMgr.queryIntentActivities(mainIntent, 0);

        try {
            for (int i = 0; i < mApps.size(); i++) {
                if (mApps.get(i).activityInfo.packageName.startsWith("viva.republica.toss")) {
                    isExist = true;
                    break;
                }
            }
        } catch (Exception e) {
            isExist = false;
        }
        return isExist;
    }


//    @Override
//    public void onClick(View view) {
//        super.onClick(view);
//        switch (view.getId()) {
//            case R.id.activity_guest_thank_tv_money:
//
//                break;
//        }
//    }
}
