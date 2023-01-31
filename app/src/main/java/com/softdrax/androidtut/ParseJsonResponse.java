package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.softdrax.androidtut.api.ApiInterface;
import com.softdrax.androidtut.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParseJsonResponse extends AppCompatActivity {

    String url = "https://jsonplaceholder.typicode.com/";//GET
    TextView tvApiParsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_response);

        tvApiParsing = findViewById(R.id.tvApiParsing);
        tvApiParsing.setText("");
//        retrofit object creation
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//      convert json data to model class object
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        create a call of model class and enqueue for processing
        Call<List<Posts>> call = apiInterface.getPosts();

//        receive response data in simple model type list

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                List<Posts> posts = response.body();
                for (int i = 0; i < posts.size(); i++) {
                    tvApiParsing.append(" User Id: " + posts.get(i).getId() + "\n\n" + "Post Title: " +
                            posts.get(i).getTitle() + "\n\n"
                            + "Post Content: " + posts.get(i).getBody()+"\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });

    }
}