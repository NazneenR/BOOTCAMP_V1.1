package com.example.BOOTCAMP_1_1V;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import com.example.Adapters.ShoppingItemsListAdapter;

public class ShoppingApplication extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.example.BOOTCAMP_1_1V.R.layout.main);
        final GridView gridView = (GridView) findViewById(R.id.grid_view);

        gridView.setAdapter(new ShoppingItemsListAdapter(this));
    }
}
