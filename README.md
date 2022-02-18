# Tutorial
团队支教网站
# 项目展示
浏览器URL栏输入：sduqnzm.top:8080

# 如何运行本项目
## 1、创建本地数据库
首先创建一个名为suptea的数据库，然后运行 Tutor-Server/src/main/java/com/sdu/supportteach/init.sql 文件，完成数据库表的创建和数据插入。
将 Tutorial/Tutor-Server/src/main/resources/application.properties 文件中的 
spring.datasource.username= Your-Username
spring.datasource.password= Your-Password
等号右侧分别修改为你的数据库用户名和密码。
## 2、运行后端项目
运行Tutor-Server项目。
浏览器地址栏输入localhost:9090即可查看项目页面
## 3、运行前端项目
前端项目已继承于后端项目中。如需查看前端源码，并单独运行前端，参照 Tutor-Client/READEME.md 文件
## 解释
前端项目使用8080端口，后端项目使用9090端口
如果你运行了init.sql文件，则已经插入了一个默认账户：账号为passwordis123456，密码为123456。
