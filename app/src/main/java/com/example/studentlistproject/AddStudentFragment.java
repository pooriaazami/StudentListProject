package com.example.studentlistproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class AddStudentFragment extends Fragment {

    StudentDataHolder dataHolder;

    public AddStudentFragment(StudentDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        EditText etName = view.findViewById(R.id.et_student_list_name);
        EditText etFamily = view.findViewById(R.id.et_student_list_family);
        EditText etAge = view.findViewById(R.id.et_student_list_age);

        Button btnAddStudent = view.findViewById(R.id.btn_student_list_add);

        btnAddStudent.setOnClickListener(v -> {
            dataHolder.addStudent(
                    etName.getText().toString(),
                    etFamily.getText().toString(),
                    Integer.parseInt(etAge.getText().toString())
            );

            etName.setText("");
            etFamily.setText("");
            etAge.setText("");

            Fragment currentFragment = getParentFragmentManager().findFragmentById(R.id.fl_main_fragment_container);
            FragmentTransaction removeTransaction = getParentFragmentManager().beginTransaction().remove(currentFragment);
            removeTransaction.commit();
        });


        return view;
    }


}
