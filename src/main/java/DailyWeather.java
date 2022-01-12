import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyWeather {
    String name;
    Date date;
    String tempMax;
    String tempMin;
    String textDay;

    public DailyWeather() {}

    public DailyWeather(String name, Date date, String tempMax, String tempMin, String textDay) {
        this.name = name;
        this.date = date;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.textDay = textDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
        return "DailyWeather:\n" +
                "城市名称:" + name + '\n' +
                "日期:" + f.format(date) + '\n' +
                "最高气温（tempMax）:" + tempMax + "℃" + '\n' +
                "最低气温（tempMin）:" + tempMin + "℃" + '\n' +
                "白天天气情况（textDay）:" + textDay + '\n';
    }
}
