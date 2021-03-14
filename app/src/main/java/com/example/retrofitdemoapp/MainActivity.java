package com.example.retrofitdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
    }

    public void getTodos(View view) {
        Call<List<Todo>> call=apiInterface.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todo=response.body();
                Toast.makeText(MainActivity.this,todo.get(1).getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }

    public void getTodoUsingRouteParameter(View view) {
        Call<Todo> call=apiInterface.getTodo(1);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Todo todo=response.body();
                Toast.makeText(MainActivity.this,todo.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }

    public void getTodosUsingQuery(View view) {
        Call<List<Todo>> call=apiInterface.getTodoByQuery(2,true);
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todo=response.body();
                Toast.makeText(MainActivity.this,todo.get(1).getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }

    public void postTodo(View view) {
        Todo todo = new Todo(3, "Get me milk", false);

        Call<Todo> todoPostCall = apiInterface.postTodo(todo);
        todoPostCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Todo todo=response.body();
                Toast.makeText(MainActivity.this,todo.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }
}