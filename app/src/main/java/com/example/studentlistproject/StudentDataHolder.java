package com.example.studentlistproject;

import java.util.ArrayList;

public class StudentDataHolder {

    private StudentChangeEventListener eventListener;

    private ArrayList<Student> data;

    public StudentDataHolder(StudentChangeEventListener eventListener) {
        data = new ArrayList<>();
        this.eventListener = eventListener;
    }

    public void addStudent(String name, String family, int age) {
        data.add(new Student(name, family, age));
        eventListener.onAddStudent();

    }

    public void removeStudent(int idx) {
        data.remove(idx);
        eventListener.onRemoveStudent();
    }

    public Student get(int idx) {
        return data.get(idx);
    }

    public int size() {
        return data.size();
    }

    public interface StudentChangeEventListener {
        public void onAddStudent();

        public void onRemoveStudent();
    }

}
