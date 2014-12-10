package com.westudy;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DatePickerFragment extends DialogFragment {//implements DatePickerDialog.OnDateSetListener {
	private Activity mActivity;
    private OnDateSetListener mListener;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;

        // This error will remind you to implement an OnTimeSetListener 
        //   in your Activity if you forget
        try {
            mListener = (OnDateSetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnTimeSetListener");
        }
    }
    
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current time as the default values for the picker
		//final Calendar c = Calendar.getInstance();
		int year = 2014;
		int month = 3;
		int day = 9;
		//hour2 = getBundle();
		// Create a new instance of TimePickerDialog and return it
		 return new DatePickerDialog(mActivity, mListener, year, month, day);
	}
	
	
	//@SuppressWarnings("deprecation")
	//@Override
	//public void onDateSet(DatePicker view, int year, int month, int day) {
		// TODO Auto-generated method stub
		
		//EditText et = (EditText)view.findViewById(R.id.editText5);
		//et.setText("SHOSDIF");
		//DigitalClock dc = (DigitalClock) view.findViewById(R.id.digitalClock1);
		//dc.setText("07:99");
		//et.setText(hourOfDay +":"+ minute + ":" + 0);
	//}
}