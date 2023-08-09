package com.example.studentlistproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements StudentDataHolder.StudentChangeEventListener {
    private TextView tvStudentCount;
    private StudentDataHolder dataHolder;

    private void updateCount() {
        String stats = String.format("There are %d Students in the list", dataHolder.size());
        tvStudentCount.setText(stats);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataHolder = new StudentDataHolder(this);

        FragmentTransaction addListTransaction = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_main_fragment_container, new ListFragment(dataHolder));

        addListTransaction.commit();

        tvStudentCount = findViewById(R.id.tv_main_stats);
        updateCount();

        Button btnAddNewStudent = findViewById(R.id.btn_main_add);
        btnAddNewStudent.setOnClickListener(v -> {
            FragmentTransaction addAddStudent = getSupportFragmentManager().beginTransaction().add(R.id.fl_main_fragment_container, new AddStudentFragment(dataHolder));
            addAddStudent.commit();
        });

    }

    @Override
    public void onAddStudent() {
        updateCount();
    }

    @Override
    public void onRemoveStudent() {
        updateCount();
    }
}