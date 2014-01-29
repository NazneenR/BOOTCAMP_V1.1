package com.example.BOOTCAMP_1_1V;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
}
