**mvn打包到本地仓库：**
mvn install:install-file -Dfile=E:\user-api-1.0-SNAPSHOT.jar -DgroupId=com.dubbo.sample 
-DartifactId=user-api -Dversion=1.0-SNAPSHOT -Dpackaging=jar