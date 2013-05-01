package kr.ac.mju.mdc.mjuapp.util;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author davidkim
 *
 */
public class PixelConverter {
	private float displayWidth;
	private float displayHeight;
	private float widthRatio;
	private float heightRatio;

	public PixelConverter(Context context) {
		Display display = ((WindowManager) context.getSystemService(Activity.WINDOW_SERVICE)).getDefaultDisplay();
		displayWidth = display.getWidth();
		displayHeight = display.getHeight();
		widthRatio = displayWidth / 480.0f;
		heightRatio = displayHeight / 800.0f;
	}

	public int getWidth(int pixel) {
		return (int) (pixel * widthRatio);
	}

	public int getHeight(int pixel) {
		return (int) (pixel * heightRatio);
	}
}
/* end of file */