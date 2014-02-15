package bootcamp_1_1V.android.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bootcamp_1_1V.android.models.Product;

public class ProductsParser {
	public ArrayList<Product> parseProducts(String strJSONData){
		try {
			JSONArray productInfo = null;
			productInfo = new JSONArray(strJSONData);
			ArrayList<Product> products = new ArrayList<Product>();

			for (int index = 0; index < productInfo.length(); index++) {
				JSONObject x = new JSONObject(productInfo.getString(index));
				products.add(new Product(x.getString("title"),x.getString("description"),x.getString("image_url")));
			}
			return products;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
