package com.colo.paisesbanderas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.colo.paisesbanderas.R;
import com.colo.paisesbanderas.model.Country;
import com.colo.paisesbanderas.retrofit.ApiRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    private ListView lista;
    private TextView textSubRegion;
    private TextView textNativeName;
    private TextView textDemonym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        lista = (ListView) findViewById(R.id.idListView);

        textSubRegion = (TextView) findViewById(R.id.idSubRegion);
        textNativeName = (TextView) findViewById(R.id.idNativeName);
        textDemonym = (TextView) findViewById(R.id.idDemonym);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiRest apiRest = retrofit.create(ApiRest.class);

        String recuperacion = getIntent().getStringExtra("codigo");

        Call<Country> call = apiRest.getByCode(recuperacion);

        call.enqueue(new Callback<Country>() {

            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                if (!response.isSuccessful()){
                    return;
                }

                Country country = response.body();

                textSubRegion.setText(country.getSubregion());
                textNativeName.setText(country.getNativeName());
                textDemonym.setText(country.getDemonym());
                //textViewNumericCode.setText(Integer.toString(country.getNumericCode()));
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
            }
        });

    }
}
