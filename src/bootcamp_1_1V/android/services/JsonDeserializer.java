package bootcamp_1_1V.android.services;


import bootcamp_1_1V.android.models.Product;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {

    public JsonDeserializer() {
    }

    public List<Product> deserializeJson() {
        List<Product> products = new ArrayList<Product>();

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://xplorationstudio.com/sample_images/products_json.json");
        String strJSONData;

        HttpResponse resp = null;
        try {
            resp = httpClient.execute(httpGet);
            strJSONData = processEntity(resp.getEntity());

            JSONArray productInfo = new JSONArray(strJSONData);

            for (int index = 0; index < productInfo.length(); index++) {
                JSONObject x = new JSONObject(productInfo.getString(index));
                products.add(new Product(x.getString("title"),x.getString("description"),x.getString("image_url")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return products;
    }

    private String processEntity(HttpEntity entity)
            throws IllegalStateException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(entity
                .getContent()));
        String line, result = "";

        while ((line = br.readLine()) != null)
            result += line;
        br.close();
        return result;
    }
}
