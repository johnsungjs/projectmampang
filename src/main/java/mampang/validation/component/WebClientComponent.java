package mampang.validation.component;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Component
public class WebClientComponent {

        @Value("${proxy.enabled}")
        private String isProxyEnabled;

        @Value("${proxy.host}")
        private String proxyHost;

        @Value("${proxy.port}")
        private Integer proxyPort;

        @Value("${waba.dartmedia.timeout}")
        private Integer timeout;

        private HttpClient useHttpClient() {
                if (isProxyEnabled.equalsIgnoreCase("true")) {
                        return HttpClient.create()
                                        .proxy(proxy -> proxy
                                                        .type(ProxyProvider.Proxy.HTTP)
                                                        .host(proxyHost)
                                                        .port(proxyPort))
                                        .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG,
                                                        AdvancedByteBufFormat.TEXTUAL)
                                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout * 1000) // Increase connect timeout
                                        .responseTimeout(Duration.ofSeconds(timeout)); // Inc
                } else {
                        return HttpClient.create()
                                        .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG,
                                                        AdvancedByteBufFormat.TEXTUAL)
                                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout * 1000) // Increase connect timeout
                                        .responseTimeout(Duration.ofSeconds(timeout)); // Inc
                }
        }

        public void post(String url, Object requestBody, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                webClient.post().uri(url)
                                .accept(MediaType.ALL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(requestBody))
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnError(WebClientResponseException.class, e -> {
                                        System.err.println("Status code: " + e.getStatusCode());
                                        System.err.println("Response body: " + e.getResponseBodyAsString());
                                        System.err.println("Headers: " + e.getHeaders());
                                })
                                .doOnError(Exception.class, e -> {
                                        e.printStackTrace();
                                })
                                .subscribe(response -> {
                                        System.out.println("Response: " + response);
                                });

        }

        public void put(String url, Object requestBody, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                webClient.put().uri(url)
                                .accept(MediaType.ALL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(requestBody))
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnError(WebClientResponseException.class, e -> {
                                        System.err.println("Status code: " + e.getStatusCode());
                                        System.err.println("Response body: " + e.getResponseBodyAsString());
                                        System.err.println("Headers: " + e.getHeaders());
                                })
                                .doOnError(Exception.class, e -> {
                                        e.printStackTrace();
                                })
                                .subscribe(response -> {
                                        System.out.println("Response: " + response);
                                });

        }

        public void patch(String url, Object requestBody, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                webClient.patch().uri(url)
                                .accept(MediaType.ALL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromValue(requestBody))
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnError(WebClientResponseException.class, e -> {
                                        System.err.println("Status code: " + e.getStatusCode());
                                        System.err.println("Response body: " + e.getResponseBodyAsString());
                                        System.err.println("Headers: " + e.getHeaders());
                                })
                                .doOnError(Exception.class, e -> {
                                        e.printStackTrace();
                                })
                                .subscribe(response -> {
                                        System.out.println("Response: " + response);
                                });

        }

        public void delete(String url, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                webClient.delete().uri(url)
                                .accept(MediaType.ALL)
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnError(WebClientResponseException.class, e -> {
                                        System.err.println("Status code: " + e.getStatusCode());
                                        System.err.println("Response body: " + e.getResponseBodyAsString());
                                        System.err.println("Headers: " + e.getHeaders());
                                })
                                .doOnError(Exception.class, e -> {
                                        e.printStackTrace();
                                })
                                .subscribe(response -> {
                                        System.out.println("Response: " + response);
                                });

        }

        public Object get(String url, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                return webClient.get()
                                .uri(url)
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnNext(System.out::println)
                                .block();
        }

        public Object postBlock(String url, Object requestBody, String token) {
                HttpClient httpClient = useHttpClient();

                WebClient webClient = WebClient.builder()
                                .clientConnector(new ReactorClientHttpConnector(httpClient))
                                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .defaultHeader(HttpHeaders.ALLOW, MediaType.ALL_VALUE)
                                .defaultHeader(HttpHeaders.AUTHORIZATION, token)
                                .build();

                return webClient.post()
                                .uri(url)
                                .body(BodyInserters.fromValue(requestBody))
                                .retrieve()
                                .bodyToMono(Object.class)
                                .doOnNext(System.out::println)
                                .block();
        }
}

