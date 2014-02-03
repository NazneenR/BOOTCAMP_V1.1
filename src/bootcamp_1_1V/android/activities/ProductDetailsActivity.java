package bootcamp_1_1V.android.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import bootcamp_1_1V.android.R;
import bootcamp_1_1V.android.constants.Constants;

import static bootcamp_1_1V.android.constants.Constants.*;


public class ProductDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_details);
		Bundle extras = getIntent().getExtras();
		String title = extras.getString(TITLE_KEY);
		String description = extras.getString(DESCRIPTION_KEY);
		int drawableResourceId = extras.getInt(DRAWABLE_KEY);
		TextView imageTitle = (TextView) findViewById(R.id.product_title);
		imageTitle.setText(title);
		ImageView imageView = (ImageView) findViewById(R.id.product_image);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), drawableResourceId);
        imageView.setImageBitmap(bitmap);
		TextView issueDescription = (TextView) findViewById(R.id.product_description);
		issueDescription.setText(description);
	}

}
