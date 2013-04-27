package kr.ac.mju.capstone.tripshow.login;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.main.TabsActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LogInOrSignUpActivity extends Activity implements OnClickListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // TODO Auto-generated method stub
	    setContentView(R.layout.login_or_signup_layout);
	    
	    ImageButton img_btn = (ImageButton)findViewById(R.id.login_btn);
	    img_btn.setOnClickListener(this);
	    ImageButton img_btn_1 = (ImageButton)findViewById(R.id.signup_btn);
	    img_btn_1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
			case R.id.login_btn:
				Intent intent = new Intent(LogInOrSignUpActivity.this, LoginActivity.class);
				startActivity(intent);
				break;
			case R.id.signup_btn:
				Intent intent1 = new Intent(LogInOrSignUpActivity.this, SignUpActivity.class);
				startActivity(intent1);
				break;
			default:
				break;
		}
	}
}
