package site.muleo.reactivewebservice

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GreetingClient(builder: WebClient.Builder) {

    // 스프링 부트가 WebClient.Builder 인스턴스를 자동구성해줍니다.
    // WebClient 를 만들기 위해 사용합니다.
    private final val client: WebClient =
        builder.baseUrl("http://localhost:8080").build()

    fun getMessage(): Mono<String> {
        return client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .map(Greeting::message)
    }


}