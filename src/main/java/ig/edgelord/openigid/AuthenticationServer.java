package ig.edgelord.openigid;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@code AuthenticationServer} has a {@link java.util.Map} that
 * maps a sha hash of a {@link OpenIGIDToken} to a name.
 */
public class AuthenticationServer {

    private String name;
    private String url;
    private File file;
    private Map<String, String> entries = new HashMap<>();

    public AuthenticationServer(String name, String url) throws IOException {
        this.file = File.createTempFile(name, ".oigidauth");
        this.name = name;
        this.url = url;

        downloadFile();
    }

    private void downloadFile() throws IOException {
        URL website = new URL(url);
        try (InputStream in = website.openStream()) {
            Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void mapEntries() {

    }
}
