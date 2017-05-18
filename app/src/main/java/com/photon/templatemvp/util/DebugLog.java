package com.photon.templatemvp.util;

import android.util.Log;

import com.photon.templatemvp.BuildConfig;

/**
 * Created by jumbada on 16/05/2017.
 */

public class DebugLog {

    /**
     *  Writes debugging log.
     */

    public static void write(){

            final StackTraceElement stackTrace = new Exception().getStackTrace()[1];
            String fileName = stackTrace.getFileName();
            if (fileName == null)
                fileName = "";  // It is necessary if you want to use proguard obfuscation.
            final String info = stackTrace.getMethodName() + " (" + fileName + ":"
                    + stackTrace.getLineNumber() + ")";
            final String searcherMark = " *** ";
            Log.d("", info + searcherMark );

    }


    public static void write(final String message){

            final StackTraceElement stackTrace = new Exception().getStackTrace()[1];
            String fileName = stackTrace.getFileName();
            if (fileName == null)
                fileName = "";  // It is necessary if you want to use proguard obfuscation.
            final String info = stackTrace.getMethodName() + " (" + fileName + ":"
                    + stackTrace.getLineNumber() + ")";
            final String searcherMark = " *** ";
            Log.d("", info + searcherMark + " : "  + message);

    }

  public static void write(final String className,final String message){

          final StackTraceElement stackTrace = new Exception().getStackTrace()[1];
          String fileName = stackTrace.getFileName();
          if (fileName == null)
              fileName = "";  // It is necessary if you want to use proguard obfuscation.
          final String info = stackTrace.getMethodName() + " (" + fileName + ":"
                  + stackTrace.getLineNumber() + ")";
          final String searcherMark = " *** ";
          Log.d(""+className, info + searcherMark +  " : "  + message);

  }

}
