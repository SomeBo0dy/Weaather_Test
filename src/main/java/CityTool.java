import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class CityTool {
    public static Location getLocation(String Location_ID) throws IOException, SQLException {
        //获取城市的id，name，lat，lon
        String url = "https://geoapi.qweather.com/v2/city/lookup?key=9fabdbb5f33a4afda7e4c0303f903211&location=" + Location_ID;
        // 获取HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建一个HttpGet请求
        HttpGet httpGet = new HttpGet(url);
        String json = null;
        // 发送请求,获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
        json = EntityUtils.toString(entity, "utf-8");
        //解析json
        JSONObject outJson = JSONObject.parseObject(json);
        JSONArray location = outJson.getJSONArray("location");
        JSONObject loc = location.getJSONObject(0);
        String name = loc.getString("name");
        String id = loc.getString("id");
        String lat = loc.getString("lat");//纬度
        String lon = loc.getString("lon");//经度
        Location city = new Location(name,id,lat,lon);
        Sqloperation.setID(id,name);
        return city;
    }
    public static void addThreeDaysWeather(String Location_ID) throws IOException {
        String url = "https://devapi.qweather.com/v7/weather/3d?key=9fabdbb5f33a4afda7e4c0303f903211&location=" + Location_ID;
        // 获取HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建一个HttpGet请求
        HttpGet httpGet = new HttpGet(url);
        String json = null;
        // 发送请求,获取响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
        json = EntityUtils.toString(entity, "utf-8");
        //解析json
        JSONObject outJson = JSONObject.parseObject(json);
        JSONArray daily = outJson.getJSONArray("daily");
        for (int i = 0; i < daily.size(); i++) {
            JSONObject day = daily.getJSONObject(i);
            Date date = day.getDate("fxDate");
            String tempMax = day.getString("tempMax");
            String tempMin = day.getString("tempMin");
            String textDay = day.getString("textDay");
            String name = Sqloperation.findCityName(Location_ID);
            Sqloperation.addWeather(name, new java.sql.Date(date.getTime()),tempMax,tempMin,textDay);
        }
    }
}