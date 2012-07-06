package at.valli.savage.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import at.valli.savage.R;
import at.valli.savage.db.DAO;
import at.valli.savage.db.ServerCursorAdatper;
import at.valli.savage.domain.Server;

/**
 * Created 27.03.12 - 12:37
 *
 * @author valli
 */
public class Bookmarks extends ListActivity {

    private DAO dao;
    private Cursor cursor;
    private ServerCursorAdatper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmarks);

        dao = DAO.getInstance();
        dao.open(getApplicationContext());

        cursor = dao.fetch();
        startManagingCursor(cursor);

        adapter = new ServerCursorAdatper(getApplicationContext(), cursor);
        setListAdapter(adapter);

        registerForContextMenu(getListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_bookmarks, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        cursor.moveToPosition(info.position);

        Server server = new Server();

        server.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DAO.KEY_ID)));
        server.setName(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_NAME)));
        server.setHost(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_HOST)));
        server.setPort(cursor.getInt(cursor.getColumnIndexOrThrow(DAO.KEY_PORT)));
        server.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_PASSWORD)));

        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.menu_edit:
                intent = new Intent(this, SaveEdit.class);
                intent.putExtra("SERVER", server);
                startActivity(intent);
                cursor = dao.fetch();
                adapter.changeCursor(cursor);
                return true;
            case R.id.menu_delete:
                dao.delete(Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow(DAO.KEY_ID))));
                cursor = dao.fetch();
                adapter.changeCursor(cursor);
                return true;
            case R.id.menu_connect:
                intent = new Intent(this, Connect.class);
                intent.putExtra("SERVER", server);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dao != null) {
            dao.close();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        cursor.moveToPosition(position);

        Server server = new Server();
        server.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DAO.KEY_ID)));
        server.setName(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_NAME)));
        server.setHost(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_HOST)));
        server.setPort(cursor.getInt(cursor.getColumnIndexOrThrow(DAO.KEY_PORT)));
        server.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(DAO.KEY_PASSWORD)));

        Intent intent = new Intent(this, Connect.class);
        intent.putExtra("SERVER", server);

        startActivity(intent);
    }
}
