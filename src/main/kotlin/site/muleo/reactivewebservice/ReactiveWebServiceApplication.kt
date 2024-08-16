package site.muleo.reactivewebservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class ReactiveWebServiceApplication

fun main(args: Array<String>) {
    val context: ConfigurableApplicationContext =
        runApplication<ReactiveWebServiceApplication>(*args)
    val greetingClient = context.getBean(GreetingClient::class.java)

    // We need to block for the content here or the JVM might exit before the message is logged
    println(">> message = ${greetingClient.getMessage().block()}")
}
