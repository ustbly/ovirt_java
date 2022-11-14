import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and print the names and identifiers of all the virtual machines:
public class test2_listVms {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
                .url("https://engine/ovirt-engine/api")
                .user("admin@internal")
                .password("123456")
                .insecure(true)
                .build();

        // Get the reference to the "vms" service:
        VmsService vmsService = connection.systemService().vmsService();

        // Use the "list" method of the "vms" service to list all the virtual machines of the system:
        List<Vm> vms = vmsService.list().send().vms();

        // Print the virtual machine names and identifiers:
        for (Vm vm : vms) {
            System.out.printf("%s: %s\n", vm.name(), vm.id());
        }

        // Close the connection to the server:
        connection.close();
    }
}