package com.aranhid.pixabayimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;

    PixabayApi api;

    ImageViewAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Hit> hits;

    EditText etSearchText, etType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(PixabayApi.API_URL)
                .build();

        api = retrofit.create(PixabayApi.class);

        hits = new ArrayList<>();

        etSearchText = findViewById(R.id.searchText);
        etType = findViewById(R.id.type);

        recyclerView = findViewById(R.id.imageView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new ImageViewAdapter(hits);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {
        String searchText = etSearchText.getText().toString();
        String image_type = etType.getText().toString();
        Call<Response> call = api.search(searchText, PixabayApi.KEY, image_type);
        call.enqueue(callback); // ставим запрос в очередь
    }

    Callback<Response> callback = new Callback<Response>() {
        @Override
        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

            Response r = response.body();
            hits.clear();
            hits.addAll(Arrays.asList(r.hits));
            adapter.notifyDataSetChanged();
            // TODO: отобразить, сколько картинок найдено
            Log.d("mytag", "hits:" + r); // сколько картинок нашлось
        }

        @Override
        public void onFailure(Call<Response> call, Throwable t) {
            Log.d("mytag", "Error: " + t.getLocalizedMessage());
        }
    };
}