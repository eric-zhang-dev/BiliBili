# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-optimizationpasses 5          # 指定代码的压缩级别
-dontusemixedcaseclassnames   # 是否使用大小写混合
-dontpreverify           # 混淆时是否做预校验
-verbose                # 混淆时是否记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*  # 混淆时所采用的算法
-ignorewarning#忽略警告
##记录生成的日志数据,gradle build时在本项目根目录输出##
-dump class_files.txt#apk 包内所有 class 的内部结构
-printseeds seeds.txt#未混淆的类和成员
-printusage unused.txt#列出从 apk 中删除的代码
-printmapping mapping.txt#混淆前后的映射
##声明不被混淆的jar
-libraryjars libs/X5WebView.jar

-keep class * extends android.app.Activity
-keep class * extends android.app.Application
-keep class * extends android.app.Service
-keep class * extends android.content.BroadcastReceiver
-keep class * extends android.content.ContentProvider
-keep class * extends android.preference.Preference
-keep class * extends android.support.v4.**

-keep class com.google.inject.Binder
-keepclassmembers class * {
    @com.google.inject.Inject <init>(...);
}

# There's no way to keep all @Observes methods, so use the On*Event convention to identify event handlers
-keepclassmembers class * {
    void *(**On*Event);
}

-keep class * extends android.view.View {
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keep class android.support.** {*;}
-keep class com.nineoldandroids.** {*;}
-keep class javax.annotation.** {*;}
-keep class com.google.** {*;}


#过滤泛型
-keepattributes Signature

# Gson specific classes
-keep class sun.misc.Unsafe { *; }


-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase