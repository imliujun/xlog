package com.imliujun.xlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val logPath = getExternalFilesDir(null)?.path + "/logsample/xlog"
        android.util.Log.i("test", logPath)
        Xlog.open(
            true,
            Xlog.LEVEL_DEBUG,
            Xlog.AppednerModeAsync,
            cacheDir.path + "xlog",
            logPath,
            "xlog",
            ""
        )
        Xlog.setConsoleLogOpen(true)
        Log.setLogImp(Xlog())
        Log.i("MainActivity", Log.getSysInfo())
        Log.i("MainActivity", "ok")
        Log.i("MainActivity", "结束")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.appenderClose()
    }
}
