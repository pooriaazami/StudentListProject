package com.example.studentlistproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class StatsDialog extends DialogFragment {

    private int countData;

    public StatsDialog(int countData) {
        this.countData = countData;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_stats, null, false);

        TextView tvCount = view.findViewById(R.id.tv_dialog_number);
        tvCount.setText(String.valueOf(countData));

        Button btnClose = view.findViewById(R.id.btn_dialog_close_stats);
        btnClose.setOnClickListener(v -> {
            dismiss();
        });

        builder.setView(view);
        return builder.create();
    }
}
