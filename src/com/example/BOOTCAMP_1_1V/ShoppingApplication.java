package com.example.BOOTCAMP_1_1V;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.example.Adapters.ShoppingItemsListAdapter;
import com.example.Model.Product;

public class ShoppingApplication extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.example.BOOTCAMP_1_1V.R.layout.main);
        final GridView gridView = (GridView) findViewById(R.id.grid_view);
				gridView.setLongClickable(true);

        gridView.setAdapter(new ShoppingItemsListAdapter(this));

				gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

						Product product = (Product) adapterView.getAdapter().getItem(position);
						Intent intent = new Intent(getApplicationContext(),ProductDetailsActivity.class);
								intent.putExtra(getString(R.string.title), product.getTitle());
								intent.putExtra(getString(R.string.description), product.getDescription());
								intent.putExtra(getString(R.string.imagePath), product.getDrawable());
								startActivity(intent);
							}
						});
    }
}
