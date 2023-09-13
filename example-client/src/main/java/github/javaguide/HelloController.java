package github.javaguide;

import github.javaguide.annotation.RpcReference;
import org.springframework.stereotype.Component;

/**
 * @author smile2coder
 */
@Component
public class HelloController {

    @RpcReference(version = "1.0", group = "group2")
    private HelloService helloService;

    public void test() throws InterruptedException {
        String response = this.helloService.hello(new Hello("HelloMsg", "This is description of Hello Message"));
        System.out.println("RPC response: " + response);

        Thread.sleep(12000);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.hello(new Hello("111", "222")));
        }
    }
}
