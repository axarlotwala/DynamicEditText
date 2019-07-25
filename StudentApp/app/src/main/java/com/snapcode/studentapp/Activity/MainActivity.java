package com.snapcode.studentapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.snapcode.studentapp.Adapter.StudentAdapter;
import com.snapcode.studentapp.R;
import com.snapcode.studentapp.Response.StudentResponse;
import com.snapcode.studentapp.Response.Subjects;
import com.snapcode.studentapp.Retrofit.RetrofitClient;
import com.snapcode.studentapp.Retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private List<StudentResponse> studentList;
    RecyclerView listStudent;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listStudent = findViewById(R.id.listStudent);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(this);

        setStudent();
    }

    private void setStudent() {
        studentList = new ArrayList<>();

        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);
        Call<List<StudentResponse>> responseCall = retrofitInterface.STUDENT_RESPONSE_CALL();
        responseCall.enqueue(new Callback<List<StudentResponse>>() {
            @Override
            public void onResponse(Call<List<StudentResponse>> call, Response<List<StudentResponse>> response) {

                studentList = response.body();
                Log.d("ResponseMArks",""+studentList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                listStudent.setLayoutManager(linearLayoutManager);

                StudentAdapter studentAdapter = new StudentAdapter(MainActivity.this, studentList);
                listStudent.setAdapter(studentAdapter);
            }

            @Override
            public void onFailure(Call<List<StudentResponse>> call, Throwable t) {

                Log.d("Error",""+t.toString());
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCreate :
                Intent intent = new Intent(MainActivity.this,AddStudentActivity.class);
                startActivity(intent);
                break;
        }
    }

}


