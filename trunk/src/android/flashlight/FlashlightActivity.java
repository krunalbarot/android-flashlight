package android.flashlight;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class FlashlightActivity extends Activity {
	private static int MENU_ABOUT_ID = 0;
	private static int MENU_ABOUT_GROUP = 0;
	private static int MENU_ABOUT_ORDER = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(MENU_ABOUT_GROUP, MENU_ABOUT_ID, MENU_ABOUT_ORDER, R.string.menu_item_about);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
		default:
			StringBuilder sb = new StringBuilder();
			sb.append(getString(R.string.text_about)).append("\n\n");
			sb.append(getString(R.string.text_home_page)).append(" ");
			sb.append(getString(R.string.value_home_page)).append("\n");

			AlertDialog dialog = new AlertDialog.Builder(this).setIcon(R.drawable.icon).setTitle(
					getString(R.string.dialog_about_title)).setMessage(sb.toString())
					.setPositiveButton(getString(R.string.dialog_about_ok), null).create();
			dialog.show();
		}
		return super.onOptionsItemSelected(item);
	}

}