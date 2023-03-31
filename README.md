# aoonav
一个简易的导航~ 就叫aoo吧 支持按照单个书签控制为游客显示或登录显示

# 演示站点
  https://www.uixui.com/

## 简介
```
一个简易的导航~ aoonav
快速开发产品 代码没什么可看性
支持游客模式 支持访问授权模式
支持按书签进行控制时候游客模式下显示
支持整站是否关闭游客模式
可按书签类别和书签标签进行分类管理
书签类别功能目前强制为需要登录才可以使用~ 后续有好的方向在改变
书签标签 无需登录可见
书签 可单独控制为是否登录后可见

支持修改导航页背景图   由于开发时间问题 背景图是随便找的  建议部署之后 自行更换
支持修改导航页的样式

```
## 为啥要做这个的原因

```
之前使用过heimdall  但是登录的话是是整站都会登录
后来又使用过Homarr 很好的一个导航 但是没有登录功能 需要自己加一层nginx

```
## 演示截图
<img src="https://s2.loli.net/2023/03/31/9Ebrv7mtWFZaxkY.png" title="" alt="admin2.png" width="265"><img src="https://s2.loli.net/2023/03/31/WfwNkgur64cpDBF.png" title="" alt="admin3.png" width="265">

<img src="https://s2.loli.net/2023/03/31/rSkwBisLWQYJtbv.png" title="" alt="qd.png" width="265"><img src="https://s2.loli.net/2023/03/31/mpzT3ewDskf2Cic.png" title="" alt="admin1.png" width="265">

<img title="" src="https://s2.loli.net/2023/03/31/Zy49mG1XYUHhvlz.jpg" alt="qd2.jpg" width="265"><img src="https://s2.loli.net/2023/03/31/RN7cBWYDSlZzuPb.png" title="" alt="admin4.png" width="265">

## 开发

```
spring boot 2.7.10
spring boot jpa
sqlite 
```

```
基于spring boot+sqlite 构建   docker 基础镜像为openjdk:8-jdk-alpine3.9
前端 https://github.com/xiaolanqqai/xiaolanqqai.github.io 模版、
https://github.com/WebStackPage/WebStackPage.github.io模版
可在站点设置中进行切换  切换到WebStackPage模版
容器有一些测试数据 自行删除即可
```
```
docker hub 中的构建镜像使用的  alpine 官方最新镜像 如有升级可使用src/main/docker/buildx 中自行升级构建

项目对于java 版本要求最低是java8

使用的SQLite 数据库 数据库未进行加密  可自行选择db工具打开编辑或者进行迁移升级导出等

其他就没了  docker hub 的镜像 运行后 中没有在线更新的功能

本项目 没有在线检查更新功能！

docker 镜像已经支持多架构了！arm 也可以用了
```

## java 运行方式
  在Releases下载压缩包 解压运行
  或者自行编译打包运行  注意 配置文件中的db 地址  需要自己手动修改
  
  在不二次开发的前提下 推荐使用docker
  spring boot 的static 已经放在jar 外 可自行修改样式而无需重新编译jar
  

## docker run 方式

```
docker run -d -v D:\flower\aoo\app:/app -v D:\flower\aoo\tmp:/tmp -p 28082:28081 qingfeng2336/aoonav:latest
```



## 问题

```
由于存在测试数据 部署后 会直接跳转到未对外开放 需要自动登录后台 修改站点权限
```

## 端口及目录

```
/app       这个目录必须挂载  不然一重启 数据就芜湖
/tmp

容器内端口为28081
```

## 后台信息

```
后台地址是 http://ip:port/admin/login
默认帐号为admin 默认密码为123456

暂时不支持 自定义后台地址  如果有安全担忧问题 自行添加nginx  拦截/admin下的请求
框架没啥依赖  已经最少引入依赖了 应该不存在安全问题吧
```
