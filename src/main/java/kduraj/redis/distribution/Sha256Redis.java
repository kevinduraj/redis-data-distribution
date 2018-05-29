package kduraj.redis.distribution;

import com.google.common.hash.Hashing;
import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;

public class Sha256Redis {

    private String[] cluster = {
            "192.168.0.29",
            "192.168.0.26",
            "192.168.0.27",
            "192.168.0.30"
    };

    /**
     * Stored Key and Value
     * @param key
     * @param value
     * @return
     */
    public String store_key_value(String key, String value) {


        String sha256hex = Hashing.sha256().hashString(key, StandardCharsets.UTF_16).toString();
        String node = sha256hex.substring(63);


        for(int i=0; i<=100; i++) System.out.print("-"); System.out.println();
        System.out.print("Storing Key and Value on [ Node:");

        if( (node.equals("0")) || (node.equals("1")) || (node.equals("2")) || (node.equals("3"))) {
            System.out.println(node + " IP = " + cluster[0] + " ]");
            Jedis jedis = new Jedis(cluster[0]);
            jedis.set(sha256hex, value);
            jedis.close();

        } else if ((node.equals("4")) || (node.equals("5")) || (node.equals("6")) || (node.equals("7")) )  {
            System.out.println(node + " IP = " + cluster[1] + " ]");
            Jedis jedis = new Jedis(cluster[1]);
            jedis.set(sha256hex, value);
            jedis.close();

        } else if ((node.equals("8")) || (node.equals("9")) || (node.equals("a")) || (node.equals("b")) )  {
            System.out.println(node + " IP = " + cluster[2] + " ]");
            Jedis jedis = new Jedis(cluster[2]);
            jedis.set(sha256hex, value);
            jedis.close();

        } else if ( (node.equals("c")) || (node.equals("d")) || (node.equals("e"))  || (node.equals("f")) )  {
            System.out.println(node + " IP = " + cluster[3] + " ]");
            Jedis jedis = new Jedis(cluster[3]);
            jedis.set(sha256hex, value);
            jedis.close();

        }

        System.out.println("Key = " + key + "\nHashedKey = " + sha256hex + "\nValue = " + value);

        return sha256hex;

    }

    /**
     * Retrieve Key and Value
     * @param sha256hex
     * @return
     */
    public String retrieve_key_value(String sha256hex) {

        String value = null;
        String node = sha256hex.substring(63);
        for(int i=0; i<=100; i++) System.out.print("-"); System.out.println();
        System.out.print("Retrieving Value from [ Node:");

        if((node.equals("0")) || (node.equals("1")) || (node.equals("2")) || (node.equals("3")) ) {
            System.out.println(node + " IP = " + cluster[0] + " ]");
            Jedis jedis = new Jedis(cluster[0]);
            value = jedis.get(sha256hex);
            jedis.close();

        } else if ((node.equals("4")) || (node.equals("5")) || (node.equals("6")) || (node.equals("7")) )  {
            System.out.println(node + " IP = " + cluster[1] + " ]");
            Jedis jedis = new Jedis(cluster[1]);
            value = jedis.get(sha256hex);
            jedis.close();

        } else if ((node.equals("8")) || (node.equals("9")) || (node.equals("a")) || (node.equals("b")) )  {
            System.out.println(node + " IP = " + cluster[2] + " ]");
            Jedis jedis = new Jedis(cluster[2]);
            value = jedis.get(sha256hex);
            jedis.close();

        } else if ( (node.equals("c")) || (node.equals("d")) || (node.equals("e"))  || (node.equals("f")) )  {
            System.out.println(node + " IP = " + cluster[3] + " ]");
            Jedis jedis = new Jedis(cluster[3]);
            value = jedis.get(sha256hex);
            jedis.close();

        }


        System.out.println("\nHashedKey = " + sha256hex + "\nValue = " + value + "\n");
        return value;

    }

}
