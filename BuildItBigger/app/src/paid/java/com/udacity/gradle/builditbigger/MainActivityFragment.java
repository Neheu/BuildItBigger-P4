package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.lenovo.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import java.io.IOException;


public  class MainActivityFragment extends Fragment {

    private ProgressBar mProgressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_jokes, container, false);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        ((Button)root.findViewById(R.id.tell_joke_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             new GetJokeAsyncTask().execute();
            }
        });

        mProgressBar.setVisibility(View.GONE);
        return root;
    }

   public MainActivityFragment()
    {

    }


    private class GetJokeAsyncTask  extends AsyncTask<Void, Void, String> {
        private MyApi myApiService = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }


            @Override
            protected final String doInBackground(Void... params) {
                if (myApiService == null) {  // Only do this once
                    MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                            new AndroidJsonFactory(), null)
                            .setRootUrl("http://192.168.43.67:8080/_ah/api/");
                    myApiService = builder.build();
                }

                try {
                    return myApiService.getRandomJoke().execute().getData();
                } catch (IOException e) {
                    Log.e(GetJokeAsyncTask.class.getSimpleName(), e.getMessage());
                    return null;
                }
            }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
