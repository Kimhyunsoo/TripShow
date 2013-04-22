package kr.ac.mju.capstone.tripshow.login;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.main.TabsActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignUpActivity extends Activity implements OnClickListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.signup_layout);
	    
	    ((Button)findViewById(R.id.signup_request_btn)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.signup_request_btn:
			intent = new Intent(SignUpActivity.this, TabsActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}

}
