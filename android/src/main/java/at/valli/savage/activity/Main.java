package at.valli.savage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import at.valli.savage.R;

/**
 * Created 27.03.12 - 22:39
 *
 * @author valli
 */
public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void connect(View view) {
        startActivity(new Intent(this, Connect.class));
    }

    public void bookmarks(View view) {
        startActivity(new Intent(this, Bookmarks.class));
    }

    public void add(View view) {
        startActivity(new Intent(this, SaveEdit.class));
    }

    public void about(View view) {
        startActivity(new Intent(this, About.class));
    }

}
