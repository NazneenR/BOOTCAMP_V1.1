package bootcamp_1_1V.android.repositories;

import bootcamp_1_1V.android.models.Product;
import bootcamp_1_1V.android.services.JsonDeserializer;

import java.util.List;

public class ProductRepository {

    public List<Product> getProducts() {
        return new JsonDeserializer().deserializeJson();
    }
}
