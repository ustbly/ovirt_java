import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Statistic;

// This example shows to get host statistics.
public class test3_listHostStatics {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
                .url("https://engine/ovirt-engine/api")
                .user("admin@internal")
                .password("123456")
                .insecure(true)
                .build();

        // Find the host:
        HostsService hostsService = connection.systemService().hostsService();
        Host host = hostsService.list()
                .search("name=node")
                .send()
                .hosts()
                .get(0);

        // Follow the link to the statistics and print their names and values:
        List<Statistic> stats = connection.followLink(host.statistics());
        for (Statistic stat : stats) {
            System.out.printf("%s: %s\n", stat.name(), stat.values().get(0).datum());
        }

        // Close the connection to the server:
        connection.close();
    }
}