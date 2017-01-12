package test;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Yogen on 12/31/2016.
 */
public class Application {
    public void main(String[] args) {
        System.out.println(getName());
    }

    private static String getName() {
        final Function<String, String> f = (x) -> x.toString();
        final Optional<String> name = Optional.ofNullable(null);
        return name.orElse(f.apply("abc"));
    }
}
