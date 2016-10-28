龙果开源-后台管理系统


###项目介绍
1. 框架完全是基于Spring IO platform，绝对拥抱Spring，版本的依赖关系再不用担心。
2. 前端基于 **[龙果开源-后台管理UI Roncoo AdminLTE](https://github.com/roncoo/roncoo-adminLTE/)**，高端大气上档次。
3. 实现了邮件发送功能，邮件增删改查功能
4. 代码自动生成工具使用了[龙果开源-Mybatis代码自动生成工具](https://github.com/roncoo/roncoo-mybatis-generator)

###项目愿景
根据实际项目的需求，实现一个适合由单应用扩展到多应用的架构。在项目的最初设定就是一个适合多模块扩展的架构，最初是单应用架构，以包区分模块。当项目需求增大的时候，会先实现多机部署，接下来进行项目拆分，进行集群部署。每个阶段都会整合一个架构，提供对应的解决方案。


###后台截图


###目录简介
```
roncoo-adminlte-springmvc/ 龙果开源-后台管理系统
├── src/ 源码
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │   └── webapp/
│   └── test/
│
├── support/ 
│   ├── archetype/ 模板原型（待续）
│   ├── Sql脚本/ 初始化脚本
│   └── document/ 数据结构
│
└── pom.xml maven配置文件

```


###技术框架
* 核心框架：Spring Framework
* 视图框架：Spring MVC
* 模板引擎：Freemark
* 持久层框架：Mybatis
* 数据库连接池：Alibaba Druid


###帮助文档
1. 如何发布，请看视频！ 免费，免费，免费


###下步计划
1. 继续优化，持续更新，增加各种demo实例
2. 集成Spring Session，解决单节点问题
3. 创建maven原型，实现快捷搭建项目架构


###技术交流
技术交流群：546588570
