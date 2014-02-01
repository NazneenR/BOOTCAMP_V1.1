package com.example.BOOTCAMP_1_1V;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ProductDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_details);
		Bundle extras = getIntent().getExtras();
		String title = extras.getString(getString(R.string.title));
		String description = extras.getString(getString(R.string.description));
		String image = extras.getString(getString(R.string.imagePath));
		TextView imageTitle = (TextView) findViewById(R.id.product_title);
		imageTitle.setText(title);
		ImageView issueImageView = (ImageView) findViewById(R.id.product_image);
		issueImageView.setImageURI(Uri.parse(new File(image).toString()));
		TextView issueDescription = (TextView) findViewById(R.id.product_description);
		issueDescription.setText(description);
	}

}
