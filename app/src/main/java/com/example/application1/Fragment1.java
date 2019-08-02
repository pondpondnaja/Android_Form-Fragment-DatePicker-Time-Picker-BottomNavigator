package com.example.application1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Fragment1 extends Fragment {
    public static final int DATE_REQUEST_CODE = 11;
    public static final int TIME_REQUEST_CODE = 12;
    EditText deditText;
    EditText teditText;
    String selectedDate;
    String selectedTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        deditText = view.findViewById(R.id.date_edit);
        teditText = view.findViewById(R.id.time_edit);

        final FragmentManager fm = getActivity().getSupportFragmentManager();

        deditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deditText.setHint("");
                AppCompatDialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(Fragment1.this,DATE_REQUEST_CODE);
                newFragment.show(fm, "datePicker");
            }
        });

        teditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teditText.setHint("");
                AppCompatDialogFragment timeFragment = new TimePickerFragment();
                timeFragment.setTargetFragment(Fragment1.this,TIME_REQUEST_CODE);
                timeFragment.show(fm,"timePicker");
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DATE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            selectedDate = data.getStringExtra("selectedDate");
            deditText.setText(selectedDate);
        }
        if (requestCode == TIME_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            selectedTime = data.getStringExtra("selectedTime");
            teditText.setText(selectedTime);
        }
    }
}
