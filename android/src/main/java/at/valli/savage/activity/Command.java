package at.valli.savage.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import at.valli.savage.R;
import at.valli.savage.connection.ConnectionException;
import at.valli.savage.connection.Connector;
import at.valli.savage.domain.Server;

/**
 * Created 26.03.12 - 13:47
 *
 * @author valli
 */
public class Command extends Activity {

    private EditText command;
    private TextView response;
    private Server server;
    private ProgressDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.command);

        command = (EditText) findViewById(R.id.command);
        response = (TextView) findViewById(R.id.response);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {

            Bundle extras = intent.getExtras();

            server = extras.getParcelable("SERVER");
        }
    }

    public void execute(View view) {
        new ExecuteTask().execute(command.getText().toString().trim());
    }

    class ExecuteTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... commands) {
            Connector ctrl = Connector.getInstance();

            for (String command : commands) {
                try {
                    if (server != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog = ProgressDialog.show(Command.this, "", "Executing ...");
                            }
                        });
                        return ctrl.execute(server, command);
                    }
                } catch (final ConnectionException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            if(dialog.isShowing()) {
                dialog.dismiss();
            }
            response.setText(result);
        }
    }
}
