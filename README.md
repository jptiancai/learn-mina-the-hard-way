## learn mina the hard way

### Java NIO

**java NIO 和阻塞I/O的区别及各自的优缺点?**

参见资料[1](#1),[2](#2),[4](#4)

**I/O通信模型(5种)**


**java NIO服务端和客户端代码实现**


> 没有说明NIO背后的原理是`反应器模式`.
>> 另外`java_mzd`的评论值得注意:
文章不错，理解不够！
小路可以先去看看5种IO模式的异同，体会体会，然后可以了解一下EPoll模型。
最后，还可以说一下实现这个东西需要的：访问者模式，回调方法等东西！
总的来说，赞一个~！


```
//代码说明
启动服务之后,线程会在后台一直运行,需要关闭`javaw.exe*32`

- NIOServer中read方法为空,NIOClient中read方法消息回送
 NIOServer中read方法消息回送,NIOClient中read方法为空
 
 - 服务器端和客户端的read方法都不为空,就会一直的交互下去.
```

参见资料[4](#4)
 

 


**反应器模式（Reactor pattern）的核心功能**

NIO 设计背后的基石是反应器设计模式
参见资料[8](#8)


**通道和选择器**





--------------------

### mina

**StateMachine**

- [State Design Pattern](http://sourcemaking.com/design_patterns/state)基础
- [Chapter 14 - State Machine](https://mina.apache.org/mina-project/userguide/ch14-state-machine/ch14-state-machine.html#state-inheritance)
 - 引入`IOHandlerEvents.*`
 - 自定义`State Context`
 - `PlayCommand等指令` as the last argument
- 在mina官网搜索`tapedeck`了解其版本是 [2.0.0-M2-SNAPSHO](https://git-wip-us.apache.org/repos/asf?
p=mina.git;a=blob;f=example/pom.xml;h=91ca0225c36c4510149c493b678fafe57a86bffe;hb=07da56db652eeea1e5bdb8dafd01e8de0e87b4d1),之后下载[mina,2.0.0-M2项目](http://archive.apache.org/dist/mina/2.0.0-M2/)
- [SLF4J: Failed to load class “org.slf4j.impl.StaticLoggerBinder”](http://stackoverflow.com/questions/7421612/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder):下载` slf4j-nop.jar, slf4j-simple.jar, slf4j-log4j12.jar, slf4j-jdk14.jar or logback-classic.jar`其中任一jar包添加进classpath即可


--------------------

**参考**

<div id="1">

1. [Java NIO 入门学习(通道和缓冲区)](http://unmi.cc/java-nio-channel-buffe/)
 <div id="2">
2.  [Java中的阻塞和非阻塞IO包各自的优劣思考](http://javag.iteye.com/blog/221641):分析了两个阻塞和非阻塞的瓶颈.
 <div id="3">
3.  [使用Java NIO编写高性能的服务器](http://www.iteye.com/topic/40489):多线程下载文件.
 <div id="4">
4.  [Java NIO原理图文分析及代码实现](http://weixiaolu.iteye.com/blog/1479656):通过Hadoop的学习,涉及到了`动态代理`和`java NIO`,图文并茂+代码演示.
5. [Java NIO中文版](http://pan.baidu.com/s/1uzTW4):讲解了很多基础知识,有助于理解NIO
6. [隔叶黄鹂的NIO系列](http://unmi.cc/tag/nio/)
> IBM出品的[NIO 入门](http://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html)zhuoshibucuo,但是限于篇幅很长,看起来不免烦躁,推荐`隔叶黄鹂`的`.chm`文件.
> 其中参考链接非常不错,深入浅出,强烈推荐. 

7. [Merlin 给 Java 平台带来了非阻塞 I/O](http://www.ibm.com/developerworks/cn/java/j-javaio/)
> `反应器模式（Reactor pattern）的核心功能`,`通道和选择器`

 <div id="8">
8. [Reactor模式和NIO](http://www.jdon.com/concurrent/reactor.htm#)
9. [NIO系列](http://zachary-guo.iteye.com/category/212063)
> 每个知识点`选择器`,`选择键`,`选择器基础`,`Socket 通道`,`内存映射文件`,`File Locking`,`FileChannel`和`Channel Foundation`都从内部工作原理入手,深入浅出.

 开始是看了[commons-logging 和 log4j 之间的关系](http://zachary-guo.iteye.com/blog/361177):讲解了他们之前的东家是谁,前者是`sun`,后者是`apache`
 [如何同时启动多个 tomcat 服务器](http://zachary-guo.iteye.com/blog/610049):主要是端口,关闭端口,访问端口,AJP端口,

10. [Java NIO系列](http://blog.csdn.net/Anders_Zhuo/article/category/1299564):相关资源还是不错的.
> 先有一个初步的认识,从概念上.作者和自己的经历类似啊,很有共鸣啊
> 因为要做游戏后台开发，所以打算学习一下nio，虽然nio以后再也没有更新过，有点令人失望，但是还是值得去学习的！

11. [NIO.2 入门](http://www.ibm.com/developerworks/cn/java/j-nio2-1/):共两章
12. [精通Java 7 NIO.2开发](http://www.pin5i.com/showtopic-pro-java-7-nio.2.html)



