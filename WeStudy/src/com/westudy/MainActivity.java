package com.westudy;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class MainActivity extends ActionBarActivity {
	private WebView webView;
	JavaScriptInterface JSInterface;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		//this.addJavascriptInterface(new CustomJavaScriptInterface(webViewContext), "Android");
		
		setContentView(R.layout.activity_main);
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setJavaScriptEnabled(true);
		
		//JSInterface = new JavaScriptInterface(this);
		webView.addJavascriptInterface(new JavaScriptInterface(this), "JSInterface"); 
		
		webView.loadUrl("file:///android_asset/main.html");
		
		
		//newWindow(webView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public class JavaScriptInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        JavaScriptInterface(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public void changeActivity(double x, double y)
        {
            Intent i = new Intent(MainActivity.this, CreateStudySessionActivity.class);
            i.putExtra("xCoord", x);
            i.putExtra("yCoord", y);
            startActivity(i);
            //finish();
        }
    }
	@JavascriptInterface
	public void newWindow(View view) {
		 Intent intent = new Intent(this, CreateStudySessionActivity.class);
		  startActivity(intent);
	}
}
