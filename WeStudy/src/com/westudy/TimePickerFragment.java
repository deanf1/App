package com.westudy;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment {// implements TimePickerDialog.OnTimeSetListener {
	private Activity mActivity;
    private OnTimeSetListener mListener;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current time as the default values for the picker
		final Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY) + 1;
		int minute =0;
		int hour2 = 9;
		int minute2 = 30;
		//hour2 = getBundle();
		// Create a new instance of TimePickerDialog and return it
		
		/*
		return new TimePickerDialog(getActivity(), this, hour2, minute2,
		DateFormat.is24HourFormat(getActivity()));
		*/
		
		return new TimePickerDialog(mActivity, mListener, hour, minute,
                DateFormat.is24HourFormat(mActivity));	
	}
	@Override
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        
        try {
            mListener = (OnTimeSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnTimeSetListener");
        }
	}
	
	/*
	@SuppressWarnings("deprecation")
	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// TODO Auto-generated method stub
		System.out.println("" + hourOfDay + ":" + minute);
		//EditText et = (EditText)view.findViewById(R.id.editText5);
		//et.setText("SHOSDIF");
		//DigitalClock dc = (DigitalClock) view.findViewById(R.id.digitalClock1);
		//dc.setText("07:99");
		//et.setText(hourOfDay +":"+ minute + ":" + 0);
	}
	*/
}