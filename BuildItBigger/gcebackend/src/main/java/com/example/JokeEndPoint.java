package com.example;

/**
 * Created by Neha on 09-05-2017.
 */
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;


public class JokeEndPoint {
    @Api(
            name = "apiJoke",
            version = "v1",
            namespace = @ApiNamespace(
                    ownerDomain = "backend.jokeprovider.codefactoring.com",
                    ownerName = "backend.jokeprovider.codefactoring.com",
                    packagePath = ""
            )
    )
    public class JokeEndpoint {

        @ApiMethod(name = "getJoke")
        public Joke getJoke() {
            final Joke joke = new Joke();
           // joke.setJoke(new Joker().getRandomJoke());
            return joke;
        }
    }
}
