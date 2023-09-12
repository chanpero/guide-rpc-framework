import github.javaguide.HelloService;
import github.javaguide.annotation.RpcScan;
import github.javaguide.config.RpcServiceConfig;
import github.javaguide.remoting.transport.netty.server.NettyRpcServer;
import github.javaguide.serviceimpl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Server: Automatic registration service via @RpcService annotation
 *
 * @author shuang.kou
 * @createTime 2020年05月10日 07:25:00
 */
@RpcScan(basePackage = {"github.javaguide"})
public class NettyServerMain {
    public static void main(String[] args) {
        // Register service via annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // Register service manually
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("group2")
                .version("1.0")
                .service(new HelloServiceImpl2())
                .build();
        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.start();
    }
}
