package masticat.edge.application.internal.utils;

public class EdgeUtils {

  public static String getApiKey(){
    String apiKey = System.getenv("IOT_DEVICE_API_KEY") != null ? System.getenv("IOT_DEVICE_API_KEY") : null;
    if(apiKey == null){
      throw new RuntimeException("API Key is missing in environment variables.");
    } else {
      return apiKey;
    }
  }

}
