package site.muleo.reactivewebservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveWebServiceApplication

fun main(args: Array<String>) {
    runApplication<ReactiveWebServiceApplication>(*args)
}
