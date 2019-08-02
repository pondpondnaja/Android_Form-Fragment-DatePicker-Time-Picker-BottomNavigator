package com.example.application1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Locale;

public class Fragment2 extends Fragment{
    public static final int DATE_REQUEST_CODE_2 = 12;
    public static final int TIME_REQUEST_CODE_START = 13;
    public static final int TIME_REQUEST_CODE_DONE = 14;

    EditText editText_Date;
    EditText editText_Time_start;
    EditText editText_Time_done;

    String selectedDate_2;
    String selectedTime_start;
    String selectedTime_done;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);

        final FragmentManager use_fm = getActivity().getSupportFragmentManager();

        editText_Date = view.findViewById(R.id.date_edit_2);
        editText_Time_start = view.findViewById(R.id.time_start_edit);
        editText_Time_done = view.findViewById(R.id.time_done_edit);

        editText_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDialogFragment datefragment_2 = new DatePickerFragment();
                datefragment_2.setTargetFragment(Fragment2.this,DATE_REQUEST_CODE_2);
                datefragment_2.show(use_fm, "datePicker_2");
            }
        });

        editText_Time_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDialogFragment timefragment_2_start = new TimePickerFragment();
                timefragment_2_start.setTargetFragment(Fragment2.this,TIME_REQUEST_CODE_START);
                timefragment_2_start.show(use_fm,"timePicker_start");
            }
        });

        editText_Time_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDialogFragment timefragment_2_done = new TimePickerFragment();
                timefragment_2_done.setTargetFragment(Fragment2.this,TIME_REQUEST_CODE_DONE);
                timefragment_2_done.show(use_fm,"timePicker_done");
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DATE_REQUEST_CODE_2 && resultCode == Activity.RESULT_OK) {
            selectedDate_2 = data.getStringExtra("selectedDate");
            editText_Date.setText(selectedDate_2);
        }
        if (requestCode == TIME_REQUEST_CODE_START && resultCode == Activity.RESULT_OK) {
            selectedTime_start = data.getStringExtra("selectedTime");
            editText_Time_start.setText(selectedTime_start);
        }
        if (requestCode == TIME_REQUEST_CODE_DONE && resultCode == Activity.RESULT_OK) {
            selectedTime_done = data.getStringExtra("selectedTime");
            editText_Time_done.setText(selectedTime_done);
        }
    }

}
