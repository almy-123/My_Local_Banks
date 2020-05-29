package sg.edu.rp.c346.id19037610.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs, ocbc, uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbsSelected);
        ocbc = findViewById(R.id.ocbcSelected);
        uob = findViewById(R.id.uobSelected);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==dbs){
            menu.add(0, 0, 0, getString(R.string.website));
            menu.add(0, 1, 1, getString(R.string.contact));
        }else if(v==ocbc){
            menu.add(0, 2, 0, getString(R.string.website));
            menu.add(0, 3, 1, getString(R.string.contact));
        }else if(v==uob){
            menu.add(0, 4, 0, getString(R.string.website));
            menu.add(0, 5, 1, getString(R.string.contact));
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==0){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
            startActivity(intent);
            return true;
        }else if(item.getItemId()==1){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsNum)));
            startActivity(intent);
            return true;
        }else if(item.getItemId()==2){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
            startActivity(intent);
            return true;
        }else if(item.getItemId()==3){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcNum)));
            startActivity(intent);
            return true;
        }else if(item.getItemId()==4){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
            startActivity(intent);
            return true;
        }else if(item.getItemId()==5){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobNum)));
            startActivity(intent);
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.English){
            dbs.setText(getString(R.string.dbs));
            ocbc.setText(getString(R.string.ocbc));
            uob.setText(getString(R.string.uob));
        }else if(id==R.id.Chinese){
            dbs.setText(getString(R.string.dbsChinese));
            ocbc.setText(getString(R.string.ocbcChinese));
            uob.setText(getString(R.string.uobChinese));
        }

        return super.onOptionsItemSelected(item);
    }
}
