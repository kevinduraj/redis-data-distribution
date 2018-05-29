package kduraj.redis.distribution;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

/**
 * Testing Redis Cluster 
 */
public class RedisCluster {


    HostAndPort node = new HostAndPort("kduraj.amazonaws.com", 6379);
    JedisCluster cluster = new JedisCluster(node);

    public void store_key_value(String key, String value) {

        System.out.println("Key = " + key + "\nValue = " + value);
        cluster.set(key, value);

    }

    public void disconnect() {

        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public String retrieve_key_value(String key) {
//        Jedis jedis = new Jedis(cluster[0]);
//        String value = jedis.get(key);
//        jedis.close();
//        return value;
//    }

}
