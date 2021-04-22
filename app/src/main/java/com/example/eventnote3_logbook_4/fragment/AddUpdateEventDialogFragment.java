package com.example.eventnote3_logbook_4.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;


import com.example.eventnote3_logbook_4.R;

import java.util.Calendar;


public class AddUpdateEventDialogFragment extends DialogFragment {

    public static String TAG = "UpdateEventDialogFragment";

    public enum EventType {
        Add,
        Update
    }


    private TextView tvEventType;
    private TextView tvEventId;
    private EditText etActivityName;
    private EditText etLocation;
    private TextView tvEventDate;
    private TextView tvAttendingTime;
    private EditText etReporterName;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_EVENT = "param_event";
    private static final String ARG_EVENT_LISTENER = "param_event_listener";
    private static final String ARG_EVENT_TYPE = "param_event_type";

    // TODO: Rename and change types of parameters
    private EventType eventType;

    public AddUpdateEventDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UpdateEventDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddUpdateEventDialogFragment newInstance(
            EventType eventType
            ) {
        AddUpdateEventDialogFragment fragment = new AddUpdateEventDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_EVENT_TYPE,eventType);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventType = (EventType) getArguments().getSerializable(ARG_EVENT_TYPE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_event_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    @SuppressLint("SetTextI18n")
    private void initView(View view) {
        tvEventType = view.findViewById(R.id.tvEventType);
        tvEventId = view.findViewById(R.id.tvEventId);
        etActivityName = view.findViewById(R.id.etActivityName);
        etLocation = view.findViewById(R.id.etLocation);
        tvEventDate = view.findViewById(R.id.tvEventDateUpdateEvent);
        tvAttendingTime = view.findViewById(R.id.tvAttendingTimeUpdateEvent);
        etReporterName = view.findViewById(R.id.etReporterNameUpdateEvent);
        Button btnUpdateEvent = view.findViewById(R.id.btnUpdateEventUpdateEventFragment);
        final Button btnCloseButton = view.findViewById(R.id.btnCloseBottomUpdateEventFragment);
        final ImageButton btnClose = view.findViewById(R.id.btnCloseUpdateEvent);
        final Button btnSaveEvent = view.findViewById(R.id.btnSaveEventUpdateEventFragment);
        final LinearLayout lnEventId = view.findViewById(R.id.lnEventId);


        if(this.eventType == EventType.Add) {
            tvEventType.setText("Add");
            btnUpdateEvent.setVisibility(View.INVISIBLE);
            btnSaveEvent.setVisibility(View.VISIBLE);

            lnEventId.setVisibility(View.GONE);
        } else {
            tvEventType.setText("Update");
            btnUpdateEvent.setVisibility(View.VISIBLE);
            btnSaveEvent.setVisibility(View.INVISIBLE);


        }

        tvEventDate.setOnClickListener((v) -> {
            showDatePicker();
        });

        tvAttendingTime.setOnClickListener((v) -> {
            showTimePicker();
        });

        btnUpdateEvent.setOnClickListener((v) -> {
            updateEvent();
        });

        btnSaveEvent.setOnClickListener((v) -> {
            addEvent();
        });

        btnClose.setOnClickListener((v) -> {
            dismiss();
        });

        btnCloseButton.setOnClickListener((v) -> {
            dismiss();
        });


    }

    private void updateEvent() {
        String activityName  = "";
        String location = "";
        String eventDate = "";
        String attendingTime = "";
        String reporterName = "";

        if(etActivityName.getText().toString().isEmpty()) {
            showAlert("Activity name is required!");
            return;
        } else {
            activityName = etActivityName.getText().toString();
        }

        if(etLocation.getText().toString().isEmpty()) {
            showAlert("ALocation is required!");
            return;
        } else {
            location = etLocation.getText().toString();
        }

        if(tvEventDate.getText().toString().isEmpty()) {
            showAlert("Date is required!");
            return;
        } else {
            eventDate = tvEventDate.getText().toString();
        }

        if(tvAttendingTime.getText().toString().isEmpty()) {
            showAlert("Time of attending is required!");
            return;
        } else {
            attendingTime = tvAttendingTime.getText().toString();
        }

        if(etReporterName.getText().toString().isEmpty()) {
            showAlert("Name of the reporter is required!");
            return;
        } else {
            reporterName = etReporterName.getText().toString();
        }

    }

    private void addEvent() {
        String activityName  = "";
        String location = "";
        String eventDate = "";
        String attendingTime = "";
        String reporterName = "";

        if(etActivityName.getText().toString().isEmpty()) {
            showAlert("Activity name is required!");
            return;
        } else {
            activityName = etActivityName.getText().toString();
        }

        if(etLocation.getText().toString().isEmpty()) {
            showAlert("ALocation is required!");
            return;
        } else {
            location = etLocation.getText().toString();
        }

        if(tvEventDate.getText().toString().isEmpty()) {
            showAlert("Date is required!");
            return;
        } else {
            eventDate = tvEventDate.getText().toString();
        }

        if(tvAttendingTime.getText().toString().isEmpty()) {
            showAlert("Time of attending is required!");
            return;
        } else {
            attendingTime = tvAttendingTime.getText().toString();
        }

        if(etReporterName.getText().toString().isEmpty()) {
            showAlert("Name of the reporter is required!");
            return;
        } else {
            reporterName = etReporterName.getText().toString();
        }

    }

    private void showDatePicker() {
        Calendar calendarDatePicker = Calendar.getInstance();
        @SuppressLint("SetTextI18n")
        final DatePickerDialog.OnDateSetListener listener = (v, year, monthOfYear, dayOfMonth) -> {
            String month = normalizeNumber(monthOfYear + 1);
            String day = normalizeNumber(dayOfMonth);

            tvEventDate.setText(month + "/" + day + "/" + year);
        };

        new DatePickerDialog(requireContext(), listener, calendarDatePicker
                .get(Calendar.YEAR), calendarDatePicker.get(Calendar.MONTH),
                calendarDatePicker.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showTimePicker() {
        Calendar calendarTimePicker = Calendar.getInstance();
        final TimePickerDialog.OnTimeSetListener timePickerListener =  (v, hourOfDay, minute) -> {
            String am_pm;
            int hour = hourOfDay;
            if(hour < 12) {
                am_pm = "AM";
            }
            else {
                am_pm = "PM";
                hour %= 12;
                if(hour == 0)
                    hour = 12;
            }
            String time = normalizeNumber(hour) + ":" + normalizeNumber(minute) + " " + am_pm;
            tvAttendingTime.setText(time);
        };


        int hour = calendarTimePicker.get(Calendar.HOUR);
        int minute = calendarTimePicker.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(
                requireContext(),
                timePickerListener,
                hour,
                minute,
                false);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void showAlert(String message) {
        new AlertDialog.Builder(requireContext())
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })
                .show();
    }

    private String normalizeNumber(int number) {
        if(number/10 == 0)
            return "0" + number;
        return Integer.toString(number);
    }
}