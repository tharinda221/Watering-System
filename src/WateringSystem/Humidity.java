
package WateringSystem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;


import com.eclipsesource.json.JsonObject;

public class Humidity {
//http://api.openweathermap.org/data/2.5/weather?lat=80.6242&lon=7.47355
	private static final String targetURL = "http://api.openweathermap.org/data/2.5/weather?lat=7.47355&lon=80.6242";
  
	public int getWeatherData(){

		return (int)getData()[1];
	}
	
	public double [] getData() {

		double data []=new double[2];
		  try {

			URL restServiceURL = new URL(targetURL);

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP GET Request Failed with Error code : "
						+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
				(httpConnection.getInputStream())));


			//System.out.println("Output from Server:  \n");
			JsonObject js = JsonObject.readFrom(responseBuffer.readLine());
			JsonObject jj=(JsonObject)js.get("main");
			String tem=jj.get("temp").toString();
			String humidity=jj.get("humidity").toString();

			data[0]=Double.parseDouble(tem)-273;
			data[1]=Double.parseDouble(humidity);
			  httpConnection.disconnect();
//			System.out.println(js.toString());
//			System.out.println(jj.toString());
//			System.out.println(tem+" humidity:"+humidity);
			
		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return data;

		}
}