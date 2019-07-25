package com.snapcode.studentapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.snapcode.studentapp.R;
import com.snapcode.studentapp.Response.Subjects;
import com.snapcode.studentapp.Utli.OpenHelper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentMarksActivity extends AppCompatActivity {

    private ArrayList<Subjects> subjectsList;
    private TextView tvSubName,tvMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_marks);

        tvSubName = findViewById(R.id.tvSubName);
        tvMark = findViewById(R.id.tvMark);

        setMarks();
    }

    private void setMarks(){
        /*get Arraylist using intent(Gson) and convert into string to arraylist*/

        subjectsList = new ArrayList<>();

        Intent intent = getIntent();
        intent.getStringExtra(OpenHelper.STUDENT_ID);
        intent.getStringExtra(OpenHelper.STUDENT_MARK);

        Log.d("MArks",""+intent.getStringExtra(OpenHelper.STUDENT_MARK));

        Gson gson = new Gson();
        Type type = new TypeToken<List>() {}.getType();
        subjectsList =  gson.fromJson(intent.getStringExtra(OpenHelper.STUDENT_MARK),type);

        Log.d("SubList",""+subjectsList);
        for (int i=0;i<subjectsList.size();i++){

            tvSubName.setText(subjectsList.get(i).getSubject());
            tvMark.setText(subjectsList.get(i).getMarks());
        }

        Log.d("SubjectSize",""+subjectsList.size());

    }
}
