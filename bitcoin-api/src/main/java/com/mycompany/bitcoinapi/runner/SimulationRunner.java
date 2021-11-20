package com.mycompany.bitcoinapi.runner;

import com.mycompany.bitcoinapi.mapper.PriceMapper;
import com.mycompany.bitcoinapi.observer.PriceObserver;
import com.mycompany.bitcoinapi.observer.PriceSubjectRunnable;
import com.mycompany.bitcoinapi.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//@Service and @Repository are special cases of @Component. They are technically the same, but we use them for the different purposes.
//
// @Service ---> We mark beans with @Service to indicate that they're holding the business logic.
// Besides being used in the service layer, there isn't any other special use for this annotation.

//@Repository ---> its job is to catch persistence-specific exceptions and re-throw them as one of Spring’s unified unchecked exceptions.
@RequiredArgsConstructor
@Component
// CommandLineRunner --->  用于指示当一个Bean包含在SpringApplication中时应该运行的接口。
// 多个CommandLineRunner Bean可以被定义在同一个应用程序上下文中，并且可以使用Ordered接口或@Order注解来排序。
// 会在启动时自动执行run方法
public class SimulationRunner implements CommandLineRunner {

    private final PriceService priceService;
    private final PriceMapper priceMapper;
    private final PriceObserver priceObserver;

    //自动执行的代码
    @Override
    public void run(String... args) {
        //实现runnable接口
        PriceSubjectRunnable priceSubjectRunnable = new PriceSubjectRunnable(priceService, priceMapper);
        //注册到observer
        priceSubjectRunnable.register(priceObserver);
        //开启线程
        new Thread(priceSubjectRunnable).start();
    }
}
