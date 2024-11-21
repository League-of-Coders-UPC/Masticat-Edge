package masticat.edge.application.internal.utils;

public class EdgeUtils {

  public static String getApiKey(){
    String apiKey = System.getenv("IOT_DEVICE_API_KEY") != null ? System.getenv("IOT_DEVICE_API_KEY") : "a9b3c1f5d2e7g6h8j9k0l1m2n3o4p5q";
    if(apiKey == null){
      throw new RuntimeException("API Key is missing in environment variables.");
    } else {
      return apiKey;
    }
  }

}
