package edu.aku.hassannaqvi.leap1sf_12v2.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 12/2/2016.
 */

public class RandsContract {
    private static final String TAG = "RANDs_CONTRACT";

    private Long _ID;

    // for child level Randomisation

    private String LUID;
    private String subAreaCode; // hh02
    private String houseHold;  // Structure
    private String child_name;

    public RandsContract() {
    }


    public RandsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getLong(singleChild._ID);
        this.LUID = jsonObject.getString(singleChild.COLUMN_NAME_UID);
        this.subAreaCode = jsonObject.getString(singleChild.COLUMN_NAME_SUBAREACODE);
        this.houseHold = jsonObject.getString(singleChild.COLUMN_NAME_HOUSEHOLD);
        this.child_name = jsonObject.getString(singleChild.COLUMN_NAME_CHILD_NAME);
        return this;

    }

    public RandsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getLong(cursor.getColumnIndex(singleChild._ID));
        this.LUID = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_NAME_UID));
        this.subAreaCode = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_NAME_SUBAREACODE));
        this.houseHold = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_NAME_HOUSEHOLD));
        this.child_name = cursor.getString(cursor.getColumnIndex(singleChild.COLUMN_NAME_CHILD_NAME));
        return this;
    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getLUID() {
        return LUID;
    }

    public void setLUID(String LUID) {
        this.LUID = LUID;
    }

    public String getSubAreaCode() {
        return subAreaCode;
    }

    public void setSubAreaCode(String subAreaCode) {
        this.subAreaCode = subAreaCode;
    }

    public String getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(String houseHold) {
        this.houseHold = houseHold;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(singleChild._ID, this._ID);
        json.put(singleChild.COLUMN_NAME_UID, this.LUID);
        json.put(singleChild.COLUMN_NAME_SUBAREACODE, this.subAreaCode);
        json.put(singleChild.COLUMN_NAME_HOUSEHOLD, this.houseHold);
        json.put(singleChild.COLUMN_NAME_CHILD_NAME, this.child_name);

        return json;
    }

    public static abstract class singleChild implements BaseColumns {

        public static final String TABLE_NAME = "Randomisation";
        public static final String _ID = "id";
        public static final String COLUMN_NAME_UID = "uid";
        public static final String COLUMN_NAME_SUBAREACODE = "subareacode";
        public static final String COLUMN_NAME_HOUSEHOLD = "household";
        public static final String COLUMN_NAME_CHILD_NAME = "child_name";

    }

}
