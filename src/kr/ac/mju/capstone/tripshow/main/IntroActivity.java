package kr.ac.mju.capstone.tripshow.main;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.login.LogInOrSignUpActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO Auto-generated method stub
		setContentView(R.layout.intro_layout);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					Intent intent = new Intent(IntroActivity.this,
							LogInOrSignUpActivity.class);
					startActivity(intent);
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}).start();
	}
}
