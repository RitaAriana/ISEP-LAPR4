REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.orderServer\target\base.app.orderServer-1.4.0-SNAPSHOT.jar;base.app.orderServer\target\dependency*;

REM call the java VM, e.g,
java -cp %BASE_CP% eapli.base.orderServer.tcp.TcpOrderSrv