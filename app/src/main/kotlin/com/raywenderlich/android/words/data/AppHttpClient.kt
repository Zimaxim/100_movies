import io.ktor.client.*

val AppHttpClient: HttpClient by lazy {
  HttpClient()
}