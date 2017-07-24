package edu.aku.hassannaqvi.leap1sf_12v2.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.leap1sf_12v2.R;
import edu.aku.hassannaqvi.leap1sf_12v2.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.leap1sf_12v2.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1sf_12v2.core.MainApp;
import edu.aku.hassannaqvi.leap1sf_12v2.get.GetUsers;
import edu.aku.hassannaqvi.leap1sf_12v2.sync.SyncForms;

public class MainActivity extends Activity {

    private final String TAG = "MainActivity";

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    @BindView(R.id.adminsec)
    LinearLayout adminsec;
    @BindView(R.id.lblheader)
    TextView lblheader;
    @BindView(R.id.recordSummary)
    TextView recordSummary;
    @BindView(R.id.syncDevice)
    Button syncDevice;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    AlertDialog.Builder builder;
    String m_Text = "";
    private ProgressDialog pd;
    private Boolean exit = false;
    private String rSumText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (MainApp.admin) {
            adminsec.setVisibility(View.VISIBLE);
        } else {
            adminsec.setVisibility(View.GONE);
        }

        // Reset working variables
        //    MainApp.child_name = "Test";

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tag Name");

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (!m_Text.equals("")) {
                    editor.putString("tagName", m_Text);
                    editor.commit();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        if (sharedPref.getString("tagName", null) == "" || sharedPref.getString("tagName", null) == null) {
            builder.show();
        }

        DatabaseHelper db = new DatabaseHelper(this);

        //Collection<FormsContract> todaysForms = new ArrayList<>();

        //todaysForms = db.getTodayForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";
        rSumText += "=======================";
        rSumText += "\r\n\r\n";
        //rSumText += "Total Forms Today: " + todaysForms.size();
        rSumText += "\r\n";
        rSumText += "    Forms List: \r\n";
        String iStatus = "";
//        for (FormsContract fc : todaysForms) {
//
//            switch (fc.getiStatus()) {
//                case "1":
//                    iStatus = "Complete";
//                    break;
//                case "2":
//                    iStatus = "House Locked";
//                    break;
//                case "3":
//                    iStatus = "Refused";
//                    break;
//                case "4":
//                    iStatus = "Refused";
//                    break;
//            }
//
//            rSumText += fc.getLhwCode() + " " + fc.getHouseHold() + " " + iStatus;
//            rSumText += "\r\n";
//
//        }

        rSumText += "--------------------------------------------------\r\n";

        if (MainApp.admin) {
            adminsec.setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Update: " + syncPref.getString("LastUpdate", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Synced(DB): " + syncPref.getString("LastSyncDB", "Never Synced");
            rSumText += "\r\n";
        }
        recordSummary.setText(rSumText);



    }

    public void openForm(View v) {
        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            Intent oF = new Intent(MainActivity.this, SectionAActivity.class);
            startActivity(oF);
        } else {

            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Tag Name");

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    if (!m_Text.equals("")) {
                        editor.putString("tagName", m_Text);
                        editor.commit();

                        Intent oF = new Intent(MainActivity.this, SectionAActivity.class);
                        startActivity(oF);
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    }

    public void openMembers(View v) {
       /* Intent iMem = new Intent(this, MotherListActivity.class);
        startActivity(iMem);*/
    }

    public void openA(View v) {
       /* Intent iA = new Intent(this, SectionAActivity.class);
        startActivity(iA);*/
    }

    public void openEnd(View v) {
        Intent iEnd = new Intent(this, EndingActivity.class);
        startActivity(iEnd);
    }

    public void testGPS(View v) {

        SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        Log.d("MAP", "testGPS: " + sharedPref.getAll().toString());
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("Map", entry.getKey() + ": " + entry.getValue().toString());
        }

    }

    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    public void CheckCluster(View v) {
        /*Intent cluster_list = new Intent(getApplicationContext(), FormsList.class);
        cluster_list.putExtra("dssid", MainApp.regionDss);
        startActivity(cluster_list);
*/
    }

    public void syncServer(View view) {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            new SyncForms(this).execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }


    public void syncDevice(View view) {
        if (isNetworkAvailable()) {

            syncData sync = new syncData(this);
            sync.execute();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

            startActivity(new Intent(this, LoginActivity.class));

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    GetUsers us = new GetUsers(mContext);
                    Toast.makeText(mContext, "Syncing Users", Toast.LENGTH_SHORT).show();
                    us.execute();


                    SharedPreferences syncPref = getSharedPreferences("SyncInfo(DOWN)", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = syncPref.edit();

                    editor.putString("LastSyncDevice", dtToday);

                    editor.apply();
                }
            });


            return null;
        }
    }


}