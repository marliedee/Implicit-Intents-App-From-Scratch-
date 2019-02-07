package org.pursuit.implicitintentsappfromscratch.network;

import org.pursuit.implicitintentsappfromscratch.model.ZodiacOuter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {
    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacOuter> getZodiacList();
}
