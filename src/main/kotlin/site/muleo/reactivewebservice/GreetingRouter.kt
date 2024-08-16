package site.muleo.reactivewebservice

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import kotlin.reflect.jvm.javaMethod

@Configuration(proxyBeanMethods = false)
// 노출한 경로를 라우팅 해주는 라우터
class GreetingRouter {

    @Bean
    // /hello 경로에서 트래픽을 받는중... 핸들러를 통해 값을 반환
    fun route(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
    }
}