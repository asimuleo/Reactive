package site.muleo.reactivewebservice


import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest(
    @Autowired val webTestClient: WebTestClient
) {

    @Test
    fun route() {
        webTestClient
            .get().uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody(Greeting::class.java).value { greeting ->
                Assertions.assertThat(greeting.message).isEqualTo("Hello, Spring!")
            }
    }
}