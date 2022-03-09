package hu.alkfejl.util;

import java.io.IOException;
import java.util.Properties;

public final class ConnectionUtil {

    private static final Properties props;

    static{
        props = new Properties();

        try {
            props.load(ConnectionUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProps() {
        return props;
    }

    public static String getValue(String key){
        return props.getProperty(key);
    }
}
