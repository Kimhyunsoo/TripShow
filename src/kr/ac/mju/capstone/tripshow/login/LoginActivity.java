package kr.ac.mju.capstone.tripshow.login;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.main.TabsActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener, OnKeyListener{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login_layout);

	    ((Button)findViewById(R.id.login_btn)).setOnClickListener(this);
	    ((EditText)findViewById(R.id.login_pw_edit)).setOnKeyListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.login_btn:
			intent = new Intent(LoginActivity.this, TabsActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_ENTER) {
			Intent intent = new Intent(LoginActivity.this, TabsActivity.class);
			startActivity(intent);
		}
		return false;
	}

}