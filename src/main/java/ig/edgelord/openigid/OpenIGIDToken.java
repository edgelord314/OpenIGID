package ig.edgelord.openigid;

import java.security.SecureRandom;

/**
 * An {@code OpenIGIDToken} is an identifier token. <p></p>
 *
 * A token is 32 characters long and thus there are possibilities.
 *
 */
public final class OpenIGIDToken {

    private final String token;

    private static final SecureRandom RANDOM = new SecureRandom();

    OpenIGIDToken(String token) {
        this.token = token;
    }

    public static OpenIGIDToken forToken(String token) {
        return new OpenIGIDToken(token);
    }

    public static OpenIGIDToken generateToken() {
        StringBuilder tokenBuilder = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            tokenBuilder.append(nextTokenChar());
        }

        return new OpenIGIDToken(tokenBuilder.toString());
    }

    /**
     * Generates a random character for a token. <br>
     * The character returned has the ASCII values n with <p>
     * {@code n element of {32, 33, 34, 35, 36 ... 126} \ {10, 13}} <p>
     *
     * Which effectively means that the returned character is a simple
     * ASCII symbol in the range of {@code 32 - 126}, without {@code 10} and {@code 13}. <br>
     * And thus this method returns only simple ASCII characters without control
     * symbols and space chars.
     *
     * @return a random character for a token sequence
     */
    private static char nextTokenChar() {
        int code;

        do {
            code = RANDOM.nextInt(126 - 33) + 33;
        } while (code == 10 || code == 13 );

        return (char) code;
    }

    /**
     * Gets {@link #token}.
     *
     * @return the value of {@link #token}
     */
    public String getToken() {
        return token;
    }
}
