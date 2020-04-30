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

3.请问如果有多个事物管理器的话，那么在程序中怎么去选择某一个事务管理器呢
比如，@Transactional注解里就可以指定TransactionManager。

4.第一种方式用@Primary是如何实现的,有demo吗?
直接在你打算作为主要DataSource的那个Bean定义上增加@Primary注解，Spring Boot这是就会以它为主要Bean了。

# 等待完善点
1.配置了多个数据源,我们该如何配置我们初始化sql文件?
本教程目前么有实现,原来使用springboot中的自动配置,通过配置文件既可,有待研究.
通常情况也没必要,可以手动执行sql来初始化.

2.如果配置了多个数据库,那么我们如何配置数据库连接池?
目前我只配置了一个数据库连接池,不知道会不会有影响.

3.读写分离怎么弄?
多个数据源、读写分离、分库分表之类的问题感兴趣
 如果自己做的话，简单的可以手工搞，但读写分离建议配合中间件或者框架来做，会更好一些，这个我后续展开聊聊吧。
 
4.已经取消自动配置,并且设置如下,为什么还是没有成功?
foo.datasource.url=jdbc:h2:mem:foo
foo.datasource.username=sa
foo.datasource.password=
foo.datasource.schema=classpath:db/schema.sql
foo.datasource.data=classpath:db/data.sql
回答:
使用springboot有几种初始化方式，data与schema是jdbc的数据初始化方式，可以看一下jdbc包里面的init，来手动实现初始化数据库。

5.多数据源:
多个数据源配置
多个数据库连接池
多个数据库事务管理器
如何选择指定的事务管理器
