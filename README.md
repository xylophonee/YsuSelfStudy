# 燕习（YsuSelfStudy）

 **燕山大学的空教室查询系统，另外可以登录教务系统获取最新的个人考试情况。** 

![输入图片说明](https://images.gitee.com/uploads/images/2019/0326/093612_a38218e6_1760493.png "home_tiny.png")

## 项目特点
---
- 每日同步空教室的数据
- 每日一张必应美图
- 其余功能请自行发掘

## 界面预览
---
![输入图片说明](https://images.gitee.com/uploads/images/2019/0326/095129_cff6f116_1760493.png "Screenshot_2019-03-26-09-37-58-414_com.example.ys.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0326/095140_d21188ae_1760493.png "Screenshot_2019-03-26-09-38-01-102_com.example.ys.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/0326/095153_595d7a81_1760493.png "Screenshot_2019-03-26-09-38-03-510_com.example.ys.png")

## 编译环境
---
Android Studio 3.3.2

项目最低适配 Android 6.0 （SDK 23）

Jdk 11
## 更新日志
---

**2019.3.30**
- 调整了 我的考试 界面
- 新增了开启第一屏

**2019.3.29**
- 更新了服务器端代码，大幅度删减冗余数据，现在加载只需要 2 秒！

 **2019.3.26** 
 - 新增了检查更新
 - 修复了不经登录打开查询考试界面的 BUG
 
 **2019.3.25** 
- 美化了教务登录界面，未来登录界面将单纯的作为跳转界面。
- 登录界面可以保存正确的账号信息。
- 取消了图片上显式的文字，未来考虑添加到第一屏上去。

 **2019.3.24** 
- 增加了登录教务系统的功能

**2019.3.19** 
- 强制竖屏。
- 新增了下拉刷新功能。

 **2019.3.18** 
- 修复 Recycler View 在滑动时返回会崩溃的问题。主要是因为在返回时也需要对 Adapter 进行刷新。
- 发现了服务端存在着数据不完全的偶现 Bug，已经定位该问题，预计明天修复。（已修复）

**2019.3.15** 
- 修复了第二天每次打开软件数据库都得加载的问题。现在只有每天的第一次会加载了。
- 还需要设置无网络的提示功能。
- 还需要设置全部强制竖屏功能。

 **2019.3.14** 
- 更新了 QQ 登录功能。
- 新增了空教室查询系统。

 **2019.3.13** 
- 调整了爬虫方法，不再从源地址爬。更改方案为从自己的服务器上获取数据，服务器每天爬一次。
- 准备开始数据库的设计。
## 2019.3.12
- 增加了侧边栏
- 二级界面美化

 **2019.3.7** 
- 新增了基本的布局。
## 未来更新
---
* ~~图书馆的登陆接口~~
* ~~开启第一屏的欢迎~~
* ~~加速空教室的获取速度~~
* 状态栏的调整

## 鸣谢
---
[Okhttp](https://github.com/square/okhttp)

[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)

[jsoup](https://github.com/jhy/jsoup)

[BasePop](https://github.com/razerdp/BasePopup)

[AnimatedSvgView](https://github.com/jaredrummler/AnimatedSvgView)


