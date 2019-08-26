package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.api.GPHApi;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import com.giphy.sdk.ui.GPHSettings;
import com.giphy.sdk.ui.themes.GridType;
import com.giphy.sdk.ui.GiphyCoreUI;
import com.giphy.sdk.ui.views.GPHMediaView;
import com.giphy.sdk.ui.views.GifsRecyclerView;
import com.giphy.sdk.ui.views.GiphySearchBar;
import com.giphy.sdk.ui.views.buttons.GPHGifButton;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GPHMediaView resView=findViewById(R.id.media_view);

        GPHApi client = new GPHApiClient("BH39whKdp09zo2SWH5KrEUuow1fH8C5s");


        client.search("cats", MediaType.gif, null, null, null, null, null, new CompletionHandler<ListMediaResponse>() {

            @Override
            public void onComplete(ListMediaResponse result, Throwable e) {
                Media gif = null;

                if (result == null) {

                } else {
                    if (result.getData() != null) {
                        List<Media> data = result.getData();
                        for (int i = 0; i < data.size(); i++) {
                            gif = data.get(i);
                            Log.e("giphy", gif.getId());
                        }

                        resView.setMedia(gif, RenditionType.original, R.color.gph_dark_grey);
                    } else {
                        Log.e("giphy error", "No results found");
                    }
                }
            }




        });



    }

}
