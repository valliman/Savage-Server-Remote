package at.valli.savage.activity;

import android.app.Activity;
import android.os.Bundle;
import at.valli.savage.R;
import at.valli.savage.db.DAO;
import at.valli.savage.db.ServerCursorAdatper;

/**
 * Created 27.03.12 - 23:20
 *
 * @author valli
 */
public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

}
