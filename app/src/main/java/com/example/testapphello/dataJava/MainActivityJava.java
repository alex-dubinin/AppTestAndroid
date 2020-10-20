package com.example.testapphello.dataJava;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testapphello.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.include);

        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();

                        textView.append(user.getId()     + "\n");
                        textView.append(user.getUserId() + "\n");
                        textView.append(user.getTitle()  + "\n");
                        textView.append(user.getBody()   + "\n");

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        textView.append("Error during request -heeeeeeeeeeeeelp!!1");
                        t.printStackTrace();
                    }
                });
    }
}
