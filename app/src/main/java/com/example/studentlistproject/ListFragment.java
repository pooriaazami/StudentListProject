package com.example.studentlistproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    private StudentDataHolder dataHolder;

    public ListFragment(StudentDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_stu, container, false);

        RecyclerView rvStudents = view.findViewById(R.id.rv_list_list);
        rvStudents.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        rvStudents.setAdapter(new StudentList(dataHolder));

        return view;
    }

}
