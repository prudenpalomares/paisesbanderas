package com.colo.paisesbanderas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.colo.paisesbanderas.R;
import com.colo.paisesbanderas.adapters.CountriesAdapter;
import com.colo.paisesbanderas.model.Country;
import com.colo.paisesbanderas.retrofit.ApiRest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiRest apiRest = retrofit.create(ApiRest.class);

        Call<List<Country>> call = apiRest.getAll();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (!response.isSuccessful()){
                    Log.d("**","code:" + response.code());
                    return;
                }

                List<Country> countries = response.body();
                populateData(countries);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });

    }

    private void populateData(final List<Country>countries){
        CountriesAdapter countriesAdapter = new CountriesAdapter(countries, MainActivity.this);

        listView.setAdapter(countriesAdapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Country country = countries.get(position);
                intent.putExtra("codigo", country.getAlpha2Code());

                startActivity(intent);
            }
        });
    }
}
