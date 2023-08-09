package com.example.studentlistproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentList extends RecyclerView.Adapter<StudentList.StudentViewHolder> {
    private StudentDataHolder dataHolder;

    public StudentList(StudentDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bindStudent(dataHolder.get(position));
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvFamily;
        private TextView tvAge;
        private ImageView btnRemove;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_student_list_name);
            tvFamily = itemView.findViewById(R.id.tv_student_list_family);
            tvAge = itemView.findViewById(R.id.tv_student_list_age);
            btnRemove = itemView.findViewById(R.id.btn_student_list_remove);

            btnRemove.setOnClickListener(v -> {
                int idx = getAbsoluteAdapterPosition();
                dataHolder.removeStudent(idx);
                notifyItemRemoved(idx);
            });
        }

        public void bindStudent(Student stu) {
            tvName.setText(stu.getName());
            tvFamily.setText(stu.getFamily());
            tvAge.setText(String.valueOf(stu.getAge()));
        }

    }
}
