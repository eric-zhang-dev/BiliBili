# 科室版 For Android

科室版Android App客户端代码。


## 注意

- master中不再放置源码，请切换到对应tag或branch查看
- 本源码只是各代码备份


## 历史分支

| 序号 | 标签名                                      | 发布版本                |说明               | 链接               |
| ----| ---------------------------------------- | ------------------- | ---------------- |---------------- |
| 1 | --| v1.0.0  | 维护中 |--|



## 最新版开发环境

1. Android Studio >= 2.3.3
2. Gradel Version: 2.3.0
3. Gradle Plugin Version: 2.3.3
4. SDK Tool >= 25.0.2



## 项目简述

- 新版相关代码集中在app包中，其他包中代码将逐步清理。
- 项目分包方式采取功能模块进行分包，查看代码请按功能查询
- 由于接口逐步进行规范化限制，自己编译后将会出现大部分接口请求无数据的情况（这不是BUG）
- 新项目已抛弃**ListView**转而使用**Recyclerview**

#### 相关依赖

- **com.android.support**：Google官方适配包，用于提供卡片、列表、主题等基础模块
- **com.squareup.retrofit2:retrofit**：网络框架
- **com.squareup.okhttp3:okhttp**：网络框架
- **io.reactivex:rxjava**：响应式编程完美结合retrofit
- **io.reactivex:rxandroid**：
- **butterknife**：注解库，用于简化findView和onClick操作
- **com.google.zxing**：用于二维码扫描
- **com.github.bumptech.glide**：所有的图片请求管理库
- **com.google.code.gson**：Json-Model解析库，新API已弃用XML数据格式
- **com.squareup.picasso:picasso**：图片请求管理库
- **com.idescout.sql:sqlscout-server**：可视化数据库




## 其它

