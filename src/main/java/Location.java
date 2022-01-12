public class Location {
    private String name;
    private String id;
    private String lat;
    private String lon;

    public Location(String name, String id, String lat, String lon) {
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public Location() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Location：\n" +
                "城市名称:" + name + '\n' +
                "城市id:" + id + '\n' +
                "纬度(lat):" + lat + "°" + '\n' +
                "经度(lon):" + lon + "°" + '\n';
    }
}
