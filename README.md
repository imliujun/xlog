# Mars_Xlog

**本仓库是因为`xlog`官方依赖只提供了 armeabi 和 x86_64 两种 CPU 架构的 so，所以重新编译出 armeabi、armeabi-v7a、arm64-v8a、x86、x86_64 架构的 so**

**如果只需要指定架构的 so，可以使用如下方式进行过滤：**

```groovy
ndk {
            abiFilters "armeabi-v7a"
            //      abiFilters 'armeabi','x86' , 'armeabi-v7a', 'x86_64', 'arm64-v8a'
}
```



### 一、mars简介

mars 是微信官方的终端基础组件，是一个使用 C++ 编写的业务性无关，平台性无关的基础组件。 目前已接入微信 Android、iOS、Mac、Windows、WP 等客户端。

### 二、xlog简介
xlog是mars系统中可以独立使用的日志模块。

### 三、xlog优点

xlog相比其它日志模块，有如下优点：
1. 高性能高压缩率

2. 不丢失任何一行日志

3. 避免系统卡顿

4. 避免CPU波峰

5. 支持数据加密

   

## 四、简单使用

```kotlin
        val logPath = getExternalFilesDir(null)?.path + "/xlog"
        android.util.Log.i("test", logPath)
        Xlog.open(
            true,
            Xlog.LEVEL_DEBUG,
            Xlog.AppednerModeAsync,
            cacheDir.path + "/xlog",
            logPath,
            "xlog",
            ""
        )
        Xlog.setConsoleLogOpen(true)
        Log.setLogImp(Xlog())
        Log.i("MainActivity", Log.getSysInfo())
        Log.i("MainActivity", "ok")
        Log.i("MainActivity", "结束")

```

更多细节请前往[官方文档](https://github.com/Tencent/mars/wiki/Mars-Android-接入指南#xlog)



## Gradle

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.imliujun:log:1.0.0'
}
```