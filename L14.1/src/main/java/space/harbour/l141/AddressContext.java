package space.harbour.l141;

import space.harbour.l141.messageSystem.Address;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tully.
 */
public class AddressContext {
    private final Map<String, Address> addressMap = new HashMap<>();

    public void addAddress(String name, Address address) {
        addressMap.put(name, address);
    }

    public Address get(String name) {
        return addressMap.get(name);
    }
}
