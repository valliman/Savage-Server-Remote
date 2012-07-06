package at.valli.savage.db;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import at.valli.savage.R;

/**
 * Created 27.03.12 - 13:12
 *
 * @author valli
 */
public class ServerCursorAdatper extends CursorAdapter {

    public ServerCursorAdatper(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.server_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.lname);
        TextView host = (TextView) view.findViewById(R.id.lhost);
        TextView port = (TextView) view.findViewById(R.id.lport);

        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_NAME)));
        host.setText(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_HOST)));
        port.setText(Integer.toString(cursor.getInt(cursor.getColumnIndexOrThrow(DAO.KEY_PORT))));
    }

}
