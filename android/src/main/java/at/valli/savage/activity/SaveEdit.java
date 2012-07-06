package at.valli.savage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import at.valli.savage.R;
import at.valli.savage.db.DAO;
import at.valli.savage.domain.Server;

/**
 * Created 27.03.12 - 12:22
 *
 * @author valli
 */
public class SaveEdit extends Activity {

    private Server server;
    private EditText host;
    private EditText port;
    private EditText password;
    private EditText name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        name = (EditText) findViewById(R.id.sname);
        host = (EditText) findViewById(R.id.shost);
        port = (EditText) findViewById(R.id.sport);
        password = (EditText) findViewById(R.id.spassword);
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
                host.setText(server.getHost());
                port.setText(Integer.toString(server.getPort()));
                password.setText(server.getPassword());
            }
        }
    }

    public void save(View view) {
        String name = this.name.getText().toString().trim();
        String host = this.host.getText().toString().trim();
        String port = this.port.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        if (name.trim().length() == 0 || host.trim().length() == 0 || port.trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Name, host and port have to be entered!", Toast.LENGTH_LONG).show();
        } else {
            if(server == null) {
                server = new Server();
            }
            server.setName(name);
            server.setHost(host);
            server.setPort(Integer.valueOf(port));
            server.setPassword(password);

            DAO dao = DAO.getInstance();
            dao.open(getApplicationContext());

            if (server.getId() == null) {
                dao.create(server);
            } else {
                dao.update(server);
            }

            dao.close();

            startActivity(new Intent(this, Bookmarks.class));
        }
    }
}
