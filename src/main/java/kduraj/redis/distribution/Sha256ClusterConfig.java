package kduraj.redis.distribution;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.File;
import java.util.Map;


public class Sha256ClusterConfig {

    private String name;
    private int nodes;
    private Map<String, String> address;
    private String[] roles;


    /**
     * Read Cluster Config
     * @param fileName
     */
    public void readClusterConfig(String fileName) {

        File file = new File(fileName);
        String absolutePath = file.getAbsolutePath();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            Sha256ClusterConfig config = mapper.readValue(new File(absolutePath), Sha256ClusterConfig.class);
            System.out.println(ReflectionToStringBuilder.toString(config, ToStringStyle.JSON_STYLE));
            DisplayHashMap(config.address);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * Display Hash Map
     * @param map
     */
    public void DisplayHashMap(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int age) {
        this.nodes = age;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }


}

