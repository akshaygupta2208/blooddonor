package in.ebug.blooddonor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import in.ebug.blooddonor.MainActivity;
import in.ebug.blooddonor.R;

/**
 * @author : Akshay
 *
 */
public class Launcher extends Activity {
    private SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        WebView wv = (WebView) findViewById(R.id.webView);
        wv.loadUrl("file:///android_asset/launcher.html");
        sp = getSharedPreferences("foodwaysSP", Context.MODE_PRIVATE);
        new DownloadServiceData().execute(new String[]{"1"});
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private class DownloadServiceData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            //ServiceCore sc = new ServiceCore();
            /*try {
                if (sp.getString("sessionId", null) == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(
                            "sessionId",
                            telephonyManager.getDeviceId()
                                    + (int) (Math.random() * 999));
                    // ////remove this later////////
                    editor.putLong("customerId", 95);
                    editor.commit();
                }
                Thread.sleep(50000);
                // get all locations
                *//*
                String responseString = sc
                        .getRequest("http://52.76.37.190:8080/Gobazaar_Webshop/services/getLocations");
                ObjectMapper mapper = new ObjectMapper();

                JsonNode node = mapper.readTree(responseString);
                LocationWrapper locationWrapper = mapper.readValue(
                        node.path("entitiesResponse").get(0).path("baseDTO"),
                        LocationWrapper.class);
                AppCache.getCacheMap().put("locationWrapper", locationWrapper);
                // get all categories
                String responseStringCategory = sc
                        .getRequest("http://52.76.37.190:8080/Gobazaar_Webshop/services/getLiveCategory");
                JsonNode categoryNode = mapper.readTree(responseStringCategory);
                CategoryWrapper categoryWrapper = mapper.readValue(categoryNode
                                .path("entitiesResponse").get(0).path("baseDTO"),
                        CategoryWrapper.class);
                AppCache.getCacheMap().put("categoryWrapper", categoryWrapper);*//*
            } catch (Exception e1) {
                e1.printStackTrace();
            }*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Intent intent = new Intent(Launcher.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
