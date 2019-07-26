package com.colo.paisesbanderas.retrofit;

        import com.colo.paisesbanderas.model.Country;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;

public interface ApiRest {

    @GET("all")
    public Call<List<Country>> getAll();

    @GET("alpha/{cod}")
    public Call <Country> getByCode(@Path("cod") String codigo);

}

