package com.example.showbilibili;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Videos videos;
    private ListsAdapter adapter;
    private List<Lists> mLists=new ArrayList<>();
    public static final int UPDATE_LIST=1;
    RecyclerView recyclerView;

    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_LIST:
                    adapter=new ListsAdapter(mLists);
                    recyclerView.setAdapter(adapter);
                    break;
                    default:
                        break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequestWithOkHttp();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder()
                            .url("https://www.bilibili.com/index/recommend.json")
                            .build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    parseJSONWithGSON(responseData);
                    Message message =new Message();
                    message.what=UPDATE_LIST;
                    handler.sendMessage(message);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String responseData) {
        Gson gson=new Gson();
        videos=gson.fromJson(responseData,Videos.class);
        for(Lists list:videos.getList()){
           boolean result= mLists.add(list);
            Log.d("MainActivity",list.toString()+Boolean.toString(result));
        }
        Log.d("MainActivity",Integer.toString(mLists.size()));
    }
    @Override
    public void onClick(View v) {

    }
}
