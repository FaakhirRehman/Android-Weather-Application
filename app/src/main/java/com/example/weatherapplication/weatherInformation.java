package com.example.weatherapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherInformation {
    private String temp, wMain, description, icon, city, temp_min, temp_max, humidity, wind_speed;
    private int condition;

    public static weatherInformation fromJson(JSONObject jsonObject){
        try{
            weatherInformation wi = new weatherInformation();
            wi.city = jsonObject.getString("name");
            wi.condition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            wi.wMain = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            wi.description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            double temp_min = jsonObject.getJSONObject("main").getDouble("temp_min")-273.15;
            double temp_max = jsonObject.getJSONObject("main").getDouble("temp_max")-273.15;
            double humidity = jsonObject.getJSONObject("main").getDouble("humidity");

            double windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");

            int roundedValue_tempResult = (int)Math.rint(tempResult);
            wi.temp = Integer.toString(roundedValue_tempResult);

            int roundedValue_temp_min = (int)Math.rint(temp_min);
            wi.temp_min = Integer.toString(roundedValue_temp_min);

            int roundedValue_temp_max = (int)Math.rint(temp_max);
            wi.temp_max = Integer.toString(roundedValue_temp_max);

          //  int roundedValue_humidity = (int)Math.rint(humidity);
           // wi.humidity = Integer.toString(roundedValue_humidity);

            return wi;

        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getTemp() {
        return temp+" °C";
    }

    public String getwMain() {
        return wMain;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getCity() {
        return city;
    }

    public String getTemp_min() {
        return temp_min+" °C";
    }

    public String getTemp_max() {
        return temp_max+" °C";
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind_speed() {
        return wind_speed+" km/h";
    }
}
