package bootcamp_1_1V.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import bootcamp_1_1V.android.R;
import bootcamp_1_1V.android.adapters.ShoppingItemsListAdapter;
import bootcamp_1_1V.android.models.Product;

import static bootcamp_1_1V.android.constants.Constants.DESCRIPTION_KEY;
import static bootcamp_1_1V.android.constants.Constants.IMAGE_URL_KEY;
import static bootcamp_1_1V.android.constants.Constants.TITLE_KEY;

public class ShoppingActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        final GridView gridView = (GridView) findViewById(R.id.grid_view);

        gridView.setAdapter(new ShoppingItemsListAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Product product = (Product) adapterView.getAdapter().getItem(position);
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra(TITLE_KEY, product.getTitle());
                intent.putExtra(DESCRIPTION_KEY, product.getDescription());
                intent.putExtra(IMAGE_URL_KEY, product.getImageUrl());
                startActivity(intent);
            }
        });
    }
}
