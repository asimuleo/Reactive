package site.muleo.reactivewebservice

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
// 요청을 담당하는 핸들러
class GreetingHandler {

    fun hello(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(Greeting("Hello, Spring!")))
    }
}