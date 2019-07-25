package com.snapcode.studentapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.snapcode.studentapp.Activity.StudentMarksActivity;
import com.snapcode.studentapp.R;
import com.snapcode.studentapp.Response.StudentResponse;
import com.snapcode.studentapp.Response.Subjects;
import com.snapcode.studentapp.Utli.OpenHelper;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Holder> {

    private Context context;
    private List<StudentResponse> studentResponses;

    public StudentAdapter(Context context, List<StudentResponse> studentResponses) {
        this.context = context;
        this.studentResponses = studentResponses;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        holder.tvId.setText(studentResponses.get(position).get_id());
        holder.tvFullName.setText(studentResponses.get(position).getFirst_name() + " " +studentResponses.get(position).getLast_name());
       holder.tvEmail.setText(studentResponses.get(position).getEmail());
        holder.tvRollNo.setText(""+studentResponses.get(position).getRoll_no());



        holder.linearStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String marklist = gson.toJson(studentResponses.get(position).getSubjects());

                Intent intent = new Intent(context, StudentMarksActivity.class);
                intent.putExtra(OpenHelper.STUDENT_ID,studentResponses.get(position).get_id());
                intent.putExtra(OpenHelper.STUDENT_MARK,marklist);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvId,tvEmail,tvFullName,tvRollNo;
        LinearLayout linearStudent;
        RecyclerView marksList;

        public Holder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvRollNo = itemView.findViewById(R.id.tvRollNo);
            linearStudent = itemView.findViewById(R.id.linearStudent);
            marksList = itemView.findViewById(R.id.marksList);
        }
    }
}
