package com.example.penn.attemptone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Penn on 10/10/2017.
 */

public class Client {

    public static final String CE_EMPTY_FIELD_ERROR = "You have left one or more fields empty";
    public static final String CE_SUCCESS = "Creation successful. Welcome, ";

    private static User current_user = null;

    public static Employee Create(View view, Context context,String f, String l, String p,Employee.RANK r) {
        if(f.isEmpty() || l.isEmpty() || p.isEmpty() )
        {
            AlertDialog ad = new AlertDialog.Builder(context).create();
            ad.setMessage(CE_EMPTY_FIELD_ERROR);
            ad.show();
            return null;
        }
        else
        {
            //TODO: actual stuff
            AlertDialog ad = new AlertDialog.Builder(context).create();
            ad.setMessage(CE_SUCCESS.concat(f).concat(" ").concat(l).concat("."));
            ad.show();
            Employee ne = new Employee(f,l,(f.substring(0,1)).concat(l),p,r);
            return ne;
        }
    }

    public static void Login(View v, Context c, String u, String p) {
        User nu = new User(u,p);
        setCurrentUser(v,c,nu);
    }

    public static void Logout(View v, Context c) {
        current_user.clearID();
        current_user = null;
    }

    public static void Logout(View v, Context c, User u) {
        current_user.clearID();
        current_user = null;
    }

    private static void setCurrentUser(View v, Context c, User u) {
        //if(!current_user.equals(null))
        //    Logout(v,c,current_user);
        current_user = u;
    }

    public static Employee getCurrentUser() {
        return current_user.getID();
    }

}
