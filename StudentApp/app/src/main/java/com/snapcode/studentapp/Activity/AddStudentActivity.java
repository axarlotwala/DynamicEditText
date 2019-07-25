package com.snapcode.studentapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.snapcode.studentapp.R;

public class AddStudentActivity extends AppCompatActivity  {

     EditText etSubName,etMark;
     Button btnSubject;
     ImageView btnCancel;
     LinearLayout linearAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        linearAdd = findViewById(R.id.linearAdd);



    }
    public void onAdd(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View row = inflater.inflate(R.layout.dynamic_edittext, null);
        linearAdd.addView(row, linearAdd.getChildCount() - 1);
    }

    public void onDelete(View view){
        linearAdd.removeView((View) view.getParent());
    }

}
