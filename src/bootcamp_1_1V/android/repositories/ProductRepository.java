package bootcamp_1_1V.android.repositories;

import androidplugins.Callback;
import androidplugins.contentfetcher.ContentFetcher;
import bootcamp_1_1V.android.models.Product;
import bootcamp_1_1V.android.services.ProductsParser;

import java.util.ArrayList;

public class ProductRepository {

    public void getProducts(Callback<ArrayList<Product>> productsCallback) {
        new ContentFetcher(responseCallback(productsCallback), "GET").execute("http://xplorationstudio.com/sample_images/products_json.json");
    }

	private Callback<String> responseCallback(final Callback<ArrayList<Product>> productsCallback) {
		return new Callback<String>() {
			@Override
			public void execute(String strJSONData) {
				productsCallback.execute(new ProductsParser().parseProducts(strJSONData));
			}
		};
	}
}
