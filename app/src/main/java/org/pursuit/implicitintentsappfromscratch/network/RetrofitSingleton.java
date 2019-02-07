package org.pursuit.implicitintentsappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit zodiacInstance;

    public static Retrofit getInstance() {
        if (zodiacInstance != null) {
            return zodiacInstance;
        }
        zodiacInstance = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return zodiacInstance;
    }

    private RetrofitSingleton() {
    }
}
