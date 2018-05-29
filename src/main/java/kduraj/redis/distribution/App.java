package kduraj.redis.distribution;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Redis Distributed Data - proof-of-concept
 */
public class App {

    static Random random = new Random();
    final static int COUNT = 100;

    /**
     * Main Function
     * @param args
     */
    public static void main( String[] args ) {

        Sha256ClusterConfig config = new Sha256ClusterConfig();
        config.readClusterConfig("src/main/resources/cluster.yaml");
    }

    /**
     *
     */
    private static void BenchmarkRedisCluster() {

        long start = System.currentTimeMillis();
        RedisCluster cluster = new RedisCluster();

        for (int i = 1; i <= 1000; i++) {

            String key = getRandomString(32);
            String value = getRandomString(64);
            cluster.store_key_value(key, value);
        }

        cluster.disconnect();
        long end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end - start) + " milliseconds");

    }


    /**
     * Benchmark SHA256 distribution
     */
    private static void benchmarkSha256() {

        long start = System.currentTimeMillis();
        //int count = Integer.parseInt(args[0]);
        Sha256Redis redis = new Sha256Redis();

        for (int i = 1; i <= 1000; i++) {

            String key = getRandomString(32);
            String value = getRandomString(64);
            String sha256hex = redis.store_key_value(key, value);
//          String value2 = redis.retrieve_key_value(sha256hex);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end - start) + " milliseconds");
    }


    /**
     * Generate Random Strings
     * @param len
     * @return
     */
    public static String getRandomString(int len) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append((char) (random.nextInt(24) + 'a'));
        }
        return sb.toString();
    }

}
