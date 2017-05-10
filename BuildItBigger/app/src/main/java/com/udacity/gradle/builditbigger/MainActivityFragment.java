package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


public abstract class MainActivityFragment extends Fragment{

    private ProgressBar mProgressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_jokes, container, false);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);
        return root;
    }

    public abstract void tellJoke();

    protected void getJoke() {
        new GetJokeAsyncTask(this).execute();
    }



    private class GetJokeAsyncTask  extends AsyncTask<Void, Void, String> {

        public GetJokeAsyncTask(MainActivityFragment mainActivityFragment) {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
