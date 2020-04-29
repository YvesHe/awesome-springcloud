# 配置说明
application.properties : springboot项目配置文件
data.sql : 数据库数据文件
schema.sql: 数据库结构文件

# 解释说明
springboot项目在启动后会自动的去执行data.sql和schema.sql两个数据库文件,无需用户配置.

# 访问地址
http://localhost:8080/actuator/beans   : 查看bean详情,建议安装json view谷歌插件.

# 运行结果
运行结果后我们访问 http://localhost:8080/actuator/beans 地址来观察springboot我们自动创建哪些对象?
比如程序中的 JdbcTemplate 对象和 DataSource 对象都是通过springboot自动给我们配置和生成的对象

# 疑惑解答
1.为什么我们的 JdbcTemplate 和 DataSource 对象没有进行配置或声明,但是我们通过自动注入的方式还是能有值?
这些对象的新建都是springboot给我们完成的,我们不需要手动的去声明,如果需要自定义这些对象,我们可以通过接下来的例子来做.