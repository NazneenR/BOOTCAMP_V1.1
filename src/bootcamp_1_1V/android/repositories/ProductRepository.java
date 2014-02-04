package bootcamp_1_1V.android.repositories;

import bootcamp_1_1V.android.models.Product;
import bootcamp_1_1V.android.services.ContentFetcher;
import bootcamp_1_1V.android.services.ProductsParser;

import java.util.List;

public class ProductRepository {

    public List<Product> getProducts() {
        String strJSONData = new ContentFetcher().fetchResponse("http://xplorationstudio.com/sample_images/products_json.json");
		return new ProductsParser().parseProducts(strJSONData);
    }
}
