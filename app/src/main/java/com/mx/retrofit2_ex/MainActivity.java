package com.mx.retrofit2_ex;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mx.retrofit2_ex.Api.JsonPlaceHolderApi;
import com.mx.retrofit2_ex.model.LoginResultModel;

import static com.mx.retrofit2_ex.Constants.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginResultModel loginModel;
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginModel = new LoginResultModel();

        responseText = findViewById(R.id.response_text);

        findViewById(R.id.login_btn).setOnClickListener(this);
    }

    public void setUser() {
        loginModel.setName("testUser");
        loginModel.setComment("user1234");
    }

    public void apiAction() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi endPoints = retrofit.create(JsonPlaceHolderApi.class);

        endPoints.do_login(loginModel).enqueue(new Callback<LoginResultModel>() {
            @Override
            public void onResponse(Call<LoginResultModel> call, Response<LoginResultModel> response) {
                LoginResultModel result = response.body();
                String resultName = result.getName();
                String resultComment = result.getComment();

                responseText.setText(resultName + " / " + resultComment);
            }

            @Override
            public void onFailure(Call<LoginResultModel> call, Throwable t) {
                responseText.setText("response fail");
            }
        });
    }

    @Override
    public void onClick(View v) {
        int itemId = v.getId();

        if(itemId == R.id.login_btn) {
            setUser();
            apiAction();
        } else {
            Toast.makeText(this, "no item", Toast.LENGTH_LONG).show();
        }
    }
}
