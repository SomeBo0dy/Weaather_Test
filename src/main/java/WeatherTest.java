
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;


public class WeatherTest {
    @Test
    public void test() throws SQLException, IOException {
        Location city1 = CityTool.getLocation("101010100");
        System.out.println(city1);
        Sqloperation.addCity(city1);
        Location city2 = CityTool.getLocation("101020100");
        System.out.println(city2);
        Sqloperation.addCity(city2);
        Location city3 = CityTool.getLocation("101230101");
        System.out.println(city3);
        Sqloperation.addCity(city3);
        CityTool.addThreeDaysWeather("101010100");
        CityTool.addThreeDaysWeather("101020100");
        CityTool.addThreeDaysWeather("101230101");
        System.out.println(Sqloperation.getWeather("北京",new Date(new java.util.Date().getTime())));
        System.out.println(Sqloperation.getLocation("北京"));

    }


}
