# tbdj
正在听一首歌叫天兵大将（tbdj）

### 一.使用了这些工具    
//dagger两个依赖  
implementation 'com.google.dagger:dagger:2.6'  
annotationProcessor 'com.google.dagger:dagger-compiler:2.6'  
  
implementation 'com.squareup.retrofit2:retrofit:2.1.0'  
implementation 'com.squareup.retrofit2:converter-gson:2.1.0'  
implementation 'com.squareup.retrofit2:adapter-rxjava:2.1.0'  
  
implementation 'com.squareup.picasso:picasso:2.3.2'  
implementation 'com.ddz.materialdesign:FloatingActionButton:1.0.4'  
//    implementation 'com.airbnb.android:lottie:2.6.1'  
implementation 'org.greenrobot:eventbus:3.1.1'  
  
implementation 'cn.jzvd:jiaozivideoplayer:6.2.9'  
  
### 二.以学习为目的  
1.布局使用了全新的CoordinatorLayout,AppBarLayout实现了折叠的导航栏。  
2.登录页使用的TextInputLayout,点击输入获取焦点后,描述文可以上滑浮动显示。  
3.主界面使用RadioGroup和FrameLayout占位并加载Fragment,每一个Fragment都使用FragmentTransaction来管理,并且每一个Fragment都为单例模式,并标记每一个Fragment,只控制其Fragment的显示和隐藏.  
4.简单封装了Retrofit2,每次请求都会有统一的成功或者失败的函数调用,（但我并没有一个长期的借口可以使用）.
5.就是接下来的事情了  
![我是图片 我还没加载出来](https://github.com/shy4458/tbdj/blob/master/1.PNG)
![我是图片 我还没加载出来](https://github.com/shy4458/tbdj/blob/master/2.PNG)  
