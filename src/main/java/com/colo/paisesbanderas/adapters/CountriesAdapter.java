package com.colo.paisesbanderas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.colo.paisesbanderas.R;
import com.colo.paisesbanderas.model.Country;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CountriesAdapter extends BaseAdapter {

    private List<Country> paises;
    private LayoutInflater inflater;

    public CountriesAdapter(List<Country> paises, Context context) {
        this.paises = paises;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int position) {
        return paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view  = inflater.inflate(R.layout.row_country, null);

        TextView pais = (TextView) view.findViewById(R.id.idPais);
        TextView capital = (TextView) view.findViewById(R.id.idCapital);
        TextView region = (TextView) view.findViewById(R.id.idSubRegion);
        TextView population = (TextView) view.findViewById(R.id.idPopulation);
        ImageView bandera = (ImageView) view.findViewById(R.id.idBandera);

        Country country = paises.get(position);

        pais.setText(country.getName());
        capital.setText(country.getCapital());
        population.setText(country.getPopulation());
        region.setText(country.getRegion());

        String imageURL = "https://www.countryflags.io/"+ country.getAlpha2Code() + "/flat/64.png";

        Picasso.get().load(imageURL).placeholder(R.drawable.chic2).into(bandera);

        return view;
    }
}
