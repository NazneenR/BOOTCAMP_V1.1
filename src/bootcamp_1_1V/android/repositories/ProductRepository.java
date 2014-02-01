package bootcamp_1_1V.android.repositories;

import bootcamp_1_1V.android.R;
import bootcamp_1_1V.android.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public void createProduct(String title, String description) {
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("TITLE1", "DESC1", R.drawable.pic_1));
        products.add(new Product("TITLE2", "DESC2", R.drawable.pic_2));
        products.add(new Product("TITLE3", "DESC3", R.drawable.pic_3));
        return products;
    }
}
