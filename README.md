# 思考
问题一: 如果我的代码子在不同的包中,我该如何切换扫描包?
默认是扫描YvesheSpringcloudHelloApplication类所在的包,包括该包的子包,如果我们需要扫描的JavaBean不在改路径下,我们可以通过使用
@SpringBootApplication注解的scanBasePackages参数来指定扫描路径,比如:`@SpringBootApplication(scanBasePackages="com.yveshe")`

问题二: 我们启动的SpringBoot项目,默认的项目名称是没有的(http://localhost:8080/hello),该如何设置?
默认发布的项目在Root目录下,是没有项目名称的,如果我们需要像往常一样有一个项目名称改怎么办呢?答案是通过设置`server.servlet.context-path`属性为项目发布的名称既可.
比如: 配置的项目发布名称为/springcloud-helloworld, 则访问地址为 http://localhost:8080/springcloud-helloworld/hello

# 本项目讲解博客
https://yveshe.blog.csdn.net/article/details/105802265

# 参考链接
http://blog.didispace.com/spring-boot-learning-21-1-1/
