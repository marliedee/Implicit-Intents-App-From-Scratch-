package org.pursuit.implicitintentsappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.implicitintentsappfromscratch.controller.ZodiacAdapter;
import org.pursuit.implicitintentsappfromscratch.model.ZodiacOuter;
import org.pursuit.implicitintentsappfromscratch.network.RetrofitSingleton;
import org.pursuit.implicitintentsappfromscratch.network.ZodiacService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Retrofit retro;
    private String TAG = "MAIN_ACTIVITY";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.zodiac_recyclerview);

        retro = RetrofitSingleton.getInstance();
        ZodiacService service = retro.create(ZodiacService.class);
        Call<ZodiacOuter> zodiacOuterCall = service.getZodiacList();
        zodiacOuterCall.enqueue(new Callback<ZodiacOuter>(){

            @Override
            public void onResponse(Call<ZodiacOuter> call, Response<ZodiacOuter> response) {
                Log.d(TAG, "onResponse: " + response.body().getZodiac().get(0).getName());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                ZodiacAdapter adapter = new ZodiacAdapter(response.body().getZodiac());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ZodiacOuter> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());

            }
        });

    }
}
