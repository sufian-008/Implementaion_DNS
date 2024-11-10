import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class DNSRecord {
    private String domain;
    private String ipAddress;

    // Constructor for DNSRecord
    public DNSRecord(String domain, String ipAddress) {
        this.domain = domain;
        this.ipAddress = ipAddress;
    }

    // Getter for domain
    public String getDomain() {
        return domain;
    }

    // Getter for IP address
    public String getIpAddress() {
        return ipAddress;
    }
}

class IterativeDNSQuery {
    private List<DNSRecord> dnsRecords;

    // Constructor to initialize DNS records
    public IterativeDNSQuery() {
        dnsRecords = new ArrayList<>();
        dnsRecords.add(new DNSRecord("google.com", "192.164.10.1"));
        dnsRecords.add(new DNSRecord("youtube.com", "192.164.10.13"));
    }

    // Method to find IP address iteratively
    public String findIpAddress(String domain) {
        for (int i = 0; i < dnsRecords.size(); i++) {
            DNSRecord record = dnsRecords.get(i);
            if (record.getDomain().equals(domain)) {
                return record.getIpAddress();
            }
        }
        return "Not Found";
    }
}

class RecursiveDNSQuery {
    private List<DNSRecord> dnsRecords;

    // Constructor to initialize DNS records
    public RecursiveDNSQuery() {
        dnsRecords = new ArrayList<>();
        dnsRecords.add(new DNSRecord("google.com", "192.164.10.1"));
        dnsRecords.add(new DNSRecord("youtube.com", "192.164.10.13"));
    }

    // Recursive method to find IP address
    public String findIpAddress(String domain, int index) {
        // Base case: if we've reached the end of the list, return "Not Found"
        if (index >= dnsRecords.size()) {
            return "Not Found";
        }

        // Check if the current record's domain matches the input domain
        DNSRecord record = dnsRecords.get(index);
        if (record.getDomain().equals(domain)) {
            return record.getIpAddress();
        }

        // Recursive call to check the next record
        return findIpAddress(domain, index + 1);
    }

    public static void main(String[] args) {
        RecursiveDNSQuery query = new RecursiveDNSQuery();
        String ipAddress = query.findIpAddress("google.com", 0);
        System.out.println("google.com: " + ipAddress);
    }
}
