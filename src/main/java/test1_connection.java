import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SystemService;
import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;

public class test1_connection {

    public static void main(String[] args) throws Exception {
        // Create a connection to the server:
        Connection connection = connection()
                .url("https://engine/ovirt-engine/api")
                .user("admin@internal")
                .password("123456")
                .insecure(true)
                .build();

        // Get the reference to the system service:
        SystemService systemService = connection.systemService();
        // Always remember to close the connection when finished:
        connection.close();
    }
}
