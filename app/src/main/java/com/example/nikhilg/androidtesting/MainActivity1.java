package com.example.nikhilg.androidtesting;

import android.app.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//import com.facebook.FacebookSdk;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class MainActivity1 extends Activity {

//    String[] str_array={"abc","def","ghi","jkl","lmn"};
//    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
//        listview=(ListView)findViewById(R.id.listview);
//        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.activity_listview,str_array);
//        listview.setAdapter(arrayAdapter);
//        Intent intent=new Intent();
//        intent.setAction("com.example.nikhilg.androidtesting");
//        sendBroadcast(intent);
//
//            getKeyHash();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }

    private void getKeyHash() {

        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.example.nikhilg.androidtesting", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.d("hash_key", something);


            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }


}
