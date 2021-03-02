import core.Engine;
import core.PersistFlow;
import core.def.Report;
import core.persist.PersistWork;

import java.util.Map;
import java.sql.*;


public class PersistFlowTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final String DB_URL = "jdbc:mysql://localhost/test";
            final String USER = "root";
            final String PASS = "password";

            var conn = DriverManager.getConnection(DB_URL, USER, PASS);
            var stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT ctx FROM context");
            if (rs.next()){
                // 这里加入序列化逻辑 这里使用 jackson
                Map<String, Object> ctx = new ObjectMapper().readValue(rs.getString("ctx"), Map.class);
                new Engine().run(new PersistFlow().withName("persist").then(new MyWork()), ctx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyWork implements PersistWork {
    String id = "MyWork";

    @Override public Report execute(Map<String, Object> ctx) {
        System.out.println("Hello world!");
        return null;
    }
    @Override public String id() {
        return id;
    }
}