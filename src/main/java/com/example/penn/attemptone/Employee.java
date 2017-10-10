package com.example.penn.attemptone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Penn on 10/7/2017.
 */

public class Employee implements Parcelable {
    private String fname;
    private String lname;
    private String password;
    private String username;

    public enum RANK {
        NONE,
        SHFTMGR,
        GNRLMGR,
        ALL;

        //i hate this
        public static RANK intToEnum(int i) {
            switch(i){
                case 0: return RANK.NONE;
                case 1: return RANK.SHFTMGR;
                case 2: return RANK.GNRLMGR;
                case 3: return RANK.ALL;
            }
            return RANK.NONE;
        }

        public static int enumToInt(RANK e) {
            switch(e){
                case NONE: return 0;
                case SHFTMGR: return 1;
                case GNRLMGR: return 2;
                case ALL: return 3;
            }
            return 0;
        }
    }
    private RANK permissions;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(fname);
        out.writeString(lname);
        out.writeString(password);
        out.writeInt(RANK.enumToInt(permissions));
    }

    public static final Parcelable.Creator<Employee> CREATOR
            = new Parcelable.Creator<Employee>() {
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public Employee(String f, String l, String u, String p, RANK r) {
        fname = f;
        lname = l;
        password = p;
        permissions = r;
        username = fname+lname;
    }

    private Employee(Parcel in) {
        fname = in.readString();
        lname = in.readString();
        password = in.readString();
        permissions = RANK.intToEnum(in.readInt());
    }

    public String getUsername() {
        return username;
    }
}