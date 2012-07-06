package at.valli.savage.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import at.valli.savage.R;
import at.valli.savage.connection.ConnectionException;
import at.valli.savage.connection.Connector;
import at.valli.savage.domain.Server;

public class Connect extends Activity {

    private EditText host;
    private EditText port;
    private EditText password;
    private TextView name;
    private Server server;

    private ProgressDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect);

        name = (TextView) findViewById(R.id.name);
        host = (EditText) findViewById(R.id.host);
        port = (EditText) findViewById(R.id.port);
        password = (EditText) findViewById(R.id.password);

        name.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {

            Bundle extras = intent.getExtras();

            server = extras.getParcelable("SERVER");

            if (server != null) {
                name.setText(server.getName());
                name.setVisibility(View.VISIBLE);
                host.setText(server.getHost());
                port.setText(Integer.toString(server.getPort()));
                password.setText(server.getPassword());
            }
        } else {
            name.setVisibility(View.INVISIBLE);
        }
    }

    public void connect(View view) {
        if(server == null) {
            server = new Server();
            server.setId(-1L);
        }
        server.setHost(host.getText().toString());
        server.setPort(Integer.parseInt(port.getText().toString()));
        server.setPassword(password.getText().toString());
        new ConnectTask().execute(server);
    }

    private void startCommandActivity() {
        Intent intent = new Intent(this, Command.class);
        intent.putExtra("SERVER", server);
        startActivity(intent);
    }

    class ConnectTask extends AsyncTask<Server, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Server... servers) {
            Connector ctrl = Connector.getInstance();
            if (servers.length == 1) {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog = ProgressDialog.show(Connect.this, "", "Connecting ...");
                        }
                    });
                    ctrl.connect(servers[0]);
                    return true;
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
            return false;
        }

        @Override
        protected void onPostExecute(Boolean check) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            if (check) {
                startCommandActivity();
            }
        }
    }
}

