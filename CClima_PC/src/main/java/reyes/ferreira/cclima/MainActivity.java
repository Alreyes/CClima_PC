package reyes.ferreira.cclima;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
    private String TAG ="CClima_PC";

    private String API_KEY="Jh1zjiaL52uN0Q282nCVzijn8OK8aV5t8CszwMgzW6vpZUK0Lw19q2Ji44gV22NK ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(android.R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    public void descargarDatos(View view){
        //TODO Descargar a informaci�n dende un AsyncTask
        String A="A";
        String B = "B";
        Void C;
        new descargar().execute(A,C,B);

    }
    public class descargar  extends AsyncTask <String,Void,String> {
        protected String TAG="CClima_PC-descargar";
        public ProgressDialog dialogo;
        @Override
        protected String doInBackground(String... param){
            Log.i(TAG,"doInBackground iniciado");
            String resultado;
            resultado="DFG";
            return resultado;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute(){
            Log.i(TAG, "onPreExecute iniciado");
            dialogo = ProgressDialog.show(TAG,"DESCARGANDO","ESPERE...");
        }

        @Override
        protected void onPostExecute(String resultado){
            Log.i(TAG,"onPostExecute iniciado");
            dialogo=ProgressDialog.show(TAG,"DESCARGADO",resultado);
            dialogo.dismiss();

        }
    }

}

