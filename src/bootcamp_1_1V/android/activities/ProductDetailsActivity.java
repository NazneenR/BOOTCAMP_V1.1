package bootcamp_1_1V.android.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bootcamp_1_1V.BOOTCAMP_1_1V.R;

public class ProductDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_details);
		Bundle extras = getIntent().getExtras();
		String title = extras.getString(getString(R.string.title));
		String description = extras.getString(getString(R.string.description));
		int image = extras.getInt(getString(R.string.imagePath));
		TextView imageTitle = (TextView) findViewById(R.id.product_title);
		imageTitle.setText(title);
		ImageView imageView = (ImageView) findViewById(R.id.product_image);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), image);
        imageView.setImageBitmap(bitmap);
		TextView issueDescription = (TextView) findViewById(R.id.product_description);
		issueDescription.setText(description);
	}

}
