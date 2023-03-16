# aoonav
一个简易的导航~ 就叫aoo吧 支持按照单个书签控制为游客显示或登录显示

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

```
之前使用过heimdall  但是登录的话是是整站都会登录
后来又使用过Homarr 很好的一个导航 但是没有登录功能 需要自己加一层nginx

```

## 开发

```
基于spring boot+sqlite 构建   docker 基础镜像为openjdk:8-jdk-alpine3.9
前端使用了 https://github.com/xiaolanqqai/xiaolanqqai.github.io 模版

容器有一些测试数据 自行删除即可
```



## docker run 方式

```
docker run -d -v D:\flower\aoo\app:/app -v D:\flower\aoo\tmp:/tmp -p 28082:28081 qingfeng2336/aoonav:latest
```



## 问题

```
由于存在测试数据 部署后 会直接跳转到未对外开放 需要自动登录后台 修改站点权限
```

端口及目录

```
/app       这个目录必须挂载  不然一重启 数据就芜湖
/tmp

容器内端口为28081
```

## 后台信息

```
后台地址是 http://ip:port/admin/login
默认帐号为admin 默认密码为123456
```
