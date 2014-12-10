package com.westudy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.Time;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


public class CreateStudySessionActivity extends FragmentActivity implements OnTimeSetListener, OnDateSetListener {
	private int pickerHour = 0;
	private int pickerMin = 0;
	private double xValue = 0;
	private double yValue = 0;
	private int day;
	private int month;
	private int year;
	private String title;
	private String description;
	private String name;
	private int hour;
	private int minute;
	
	private EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_study_session);
		EditText et = (EditText)findViewById(R.id.TimeLabel);
		et.setText("set time");
		xValue = getIntent().getExtras().getDouble("xCoord");
		yValue = getIntent().getExtras().getDouble("yCoord");
		TextView x = (TextView)findViewById(R.id.textView6);
		TextView y = (TextView)findViewById(R.id.textView7);
		
		x.setText(Double.toString(xValue));
		y.setText(Double.toString(yValue));
	}
	public void createSess(View v) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Calendar cal = Calendar.getInstance();
		//cal.set(2013, Calendar.JANUARY, 9); //Year, month and day of month
		//Date d = cal.getTime();
		
		Date d = new Date();
		try {
			d = sdf.parse(String.format("%02d", day) + "/" + String.format("%02d", month) + "/" + String.format("%04d", year));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TextView x = (TextView)findViewById(R.id.NameLabel);
		TextView y = (TextView)findViewById(R.id.SessionTitleLabel);
		TextView z = (TextView)findViewById(R.id.DescriptionLabel);
		TextView a = (TextView)findViewById(R.id.LocationLabel);
		String name = x.getText().toString();
		String locat = a.getText().toString();
		String descrip = z.getText().toString();
		String title = y.getText().toString();

		/*String name = "lslhgdsl";
		String locat = "location";
		String descrip = "description";
		String title = "title";*/

		d.setHours(hour);
		d.setMinutes(minute);
		
		//This is the object that must be written to the file and read in MainActivity
		StudySession s = new StudySession(d, name, title, locat, descrip, xValue, yValue);
		
		
		System.out.println(s);
		System.out.println("create");
		super.onBackPressed();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.create_study_session, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void showTimePickerDialog(View v) {
	    DialogFragment newFragment = new TimePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "timePicker");
	}
	public void showDatePickerDialog(View v) {
	    DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}
	
	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int m) {
		// TODO Auto-generated method stub
		hour = hourOfDay;
		minute = m;
		EditText et = (EditText)findViewById(R.id.TimeLabel);
		et.setText(hourOfDay +":"+ m);
		//System.out.println("" + hourOfDay + ":" + minute);
		
		//DigitalClock dc = (DigitalClock) view.findViewById(R.id.digitalClock1);
		//dc.setText("07:99");
		
	}
	@Override
	public void onDateSet(DatePicker view, int y, int m, int d) {
		// TODO Auto-generated method stub
		year = y;
		month = m;
		day = d;
		EditText et = (EditText)findViewById(R.id.DateLabel);
		et.setText("" + m + "/" + d + "/" + y);
		//System.out.println("" + hourOfDay + ":" + minute);
		
		//DigitalClock dc = (DigitalClock) view.findViewById(R.id.digitalClock1);
		//dc.setText("07:99");
		
	}
	
}
