package com.example.BOOTCAMP_1_1V;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Model.Product;
import com.example.Repository.ProductRepository;

import java.util.List;

public class ShoppingApplication extends ListActivity {
    /**
     * Called when the activity is first created.
     */

    private ProductRepository productRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.example.BOOTCAMP_1_1V.R.layout.main);
        productRepository = new ProductRepository();
        List<Product> products = productRepository.getProducts();
        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1, products);
        setListAdapter(adapter);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		super.onListItemClick(l, v, position, id);
		Toast.makeText(getApplicationContext(), ((TextView) v).getText().toString(), Toast.LENGTH_SHORT).show();
	}
}
