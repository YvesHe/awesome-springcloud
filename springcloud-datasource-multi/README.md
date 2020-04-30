# 配置说明
application.properties : springboot项目配置文件
data.sql : 数据库数据文件
schema.sql: 数据库结构文件

# 解释说明
springboot项目在启动后会自动的去执行data.sql和schema.sql两个数据库文件,无需用户配置.

# 访问地址
http://localhost:8080/actuator/beans   : 查看bean详情,建议安装json view谷歌插件.

# 运行结果
运行结果后我们访问 http://localhost:8080/actuator/beans 地址来观察springboot我们创建了几个数据源对象?
很明显,我们可以看到springboot给我们配置了2个数据源:
fooDataSource
barDataSource

# 疑惑解答
1.本例子当中使用到的注解的作用是什么?
参考类上的说明.

2.为什么通过注解的方式配置Bean,会不会存在在生成有些bean的时候,一些依赖Bean没有实例化?
不会,springboot会自己处理依赖关系.

# 等待完善点
1.配置了多个数据源,我们该如何配置我们初始化sql文件?
本教程目前么有实现,原来使用springboot中的自动配置,通过配置文件既可,有待研究.
通常情况也没必要,可以手动执行sql来初始化.

2.如果配置了多个数据库,那么我们如何配置数据库连接池?
目前我只配置了一个数据库连接池,不知道会不会有影响.

