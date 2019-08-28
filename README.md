# Calculate-demo
资料：https://www.jianshu.com/p/18509c68a3fe  很简单的一个计算机


混淆+打包+验证成功

1.在app目录下的build.gradle文件中修改android{} 区域内代码

-------------------------------------
    //执行lint检查，有任何的错误或者警告提示，都会终止构建
    lintOptions {
        abortOnError false
    }
-----------------------------

  1.1替换buildTypes

-----------------------------------------------
  	buildTypes {
        debug {
            // 显示Log
            buildConfigField "boolean", "LOG_DEBUG", "true"
            versionNameSuffix "-debug"
            minifyEnabled false
            zipAlignEnabled false
            shrinkResources false
            signingConfig signingConfigs.debug
        }

        release {
            // 不显示Log
            buildConfigField "boolean", "LOG_DEBUG", "false"
            //混淆
            minifyEnabled true
            //Zipalign优化
            zipAlignEnabled true

            // 移除无用的resource文件
            shrinkResources true
            //前一部分代表系统默认的android程序的混淆文件，该文件已经包含了基本的混淆声明，后一个文件是自己的定义混淆文件
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'

        }
    }
----------------------------------------------------------------

2.修改proguard

---------------------------------------------------------

-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

#指定代码的压缩级别
-optimizationpasses 5

#包明不混合大小写
-dontusemixedcaseclassnames

#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses

 #优化  不优化输入的类文件
-dontoptimize

 #预校验
-dontpreverify

 #混淆时是否记录日志
-verbose

 # 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保护注解
-keepattributes *Annotation*

# 保持哪些类不被混淆
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
#如果有引用v4包可以添加下面这行
-keep public class * extends android.support.v4.app.Fragment


#忽略警告
-ignorewarning

##记录生成的日志数据,gradle build时在本项目根目录输出##
#apk 包内所有 class 的内部结构
-dump proguard/class_files.txt
#未混淆的类和成员
-printseeds proguard/seeds.txt
#列出从 apk 中删除的代码
-printusage proguard/unused.txt
#混淆前后的映射
-printmapping proguard/mapping.txt
########记录生成的日志数据，gradle build时 在本项目根目录输出-end######

#如果引用了v4或者v7包
-dontwarn android.support.**

####混淆保护自己项目的部分代码以及引用的第三方jar包library-end####



#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable

#保持 Serializable 不被混淆并且enum 类也不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#保持枚举 enum 类不被混淆
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

-keepclassmembers class * {
    public void *ButtonClicked(android.view.View);
}

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}

#避免混淆泛型 如果混淆报错建议关掉
#-keepattributes Signature

------------------------------------------------------------------


	2.1修改proguard是根据项目中添加的第三方额外添加的，一般在第三方文档中都有

	---------------------------------------------

	#gson
	#如果用用到Gson解析包的，直接添加下面这几行就能成功混淆，不然会报错。
	-keepattributes Signature
	# Gson specific classes
	-keep class sun.misc.Unsafe { *; }
	# Application classes that will be serialized/deserialized over Gson
	-keep class com.google.gson.** { *; }
	-keep class com.google.gson.stream.** { *; }

	#mob
	-keep class android.net.http.SslError
	-keep class android.webkit.**{*;}
	-keep class cn.sharesdk.**{*;}
	-keep class com.sina.**{*;}
	-keep class m.framework.**{*;}
	-keep class **.R$* {*;}
	-keep class **.R{*;}
	-dontwarn cn.sharesdk.**
	-dontwarn **.R$*

	#butterknife
	-keep class butterknife.** { *; }
	-dontwarn butterknife.internal.**
	-keep class **$$ViewBinder { *; }

	-keepclasseswithmembernames class * {
	    @butterknife.* <fields>;
	}

	-keepclasseswithmembernames class * {
	    @butterknife.* <methods>;
	}

	######引用的其他Module可以直接在app的这个混淆文件里配置

	# 如果使用了Gson之类的工具要使被它解析的JavaBean类即实体类不被混淆。
	-keep class com.matrix.app.entity.json.** { *; }
	-keep class com.matrix.appsdk.network.model.** { *; }

	#####混淆保护自己项目的部分代码以及引用的第三方jar包library#######
	#如果在当前的application module或者依赖的library module中使用了第三方的库，并不需要显式添加规则
	#-libraryjars xxx
	#添加了反而有可能在打包的时候遭遇同一个jar多次被指定的错误，一般只需要添加忽略警告和保持某些class不被混淆的声明。
	#以libaray的形式引用了开源项目,如果不想混淆 keep 掉，在引入的module的build.gradle中设置minifyEnabled=false
	-keep class com.nineoldandroids.** { *; }
	-keep interface com.nineoldandroids.** { *; }
	-dontwarn com.nineoldandroids.**
	# 下拉刷新
	-keep class in.srain.cube.** { *; }
	-keep interface in.srain.cube.** { *; }
	-dontwarn in.srain.cube.**
	# observablescrollview：tab fragment
	-keep class com.github.ksoichiro.** { *; }
	-keep interface com.github.ksoichiro.** { *; }
	-dontwarn com.github.ksoichiro.**

   -------------------------------------------------------------


3.打包

   资料：https://www.cnblogs.com/xqxacm/p/5897435.html

4.验证

    4.1将打包后的apk文件 手动改变文件类型为.zip ，然后解压缩，会得到一系列文件找到其中的classes.dex文件（它就是java文件编译再通过dx工具打包而成的）并将它复制到我们下载的dex2jar-2.0文件中去（当然，也可以直接解压apk；同样可以得到该文件）

    4.2然后把classes.dex文件直接拉到dex2jar.bat（这样可以直接运行，不需要进入到命令行中运行命令）

    4.3之后会在dex2jar.bat目录中生成classes_dex2jar.jar文件，并且把该文件拉到jd-gui.exe中，就可以看到代码了
