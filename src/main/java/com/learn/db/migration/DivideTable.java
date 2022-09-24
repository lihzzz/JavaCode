//package db.migration;
//
//import db.gen.GenExecutor;
//import org.apache.commons.lang3.tuple.Pair;
//import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
//import rx.Observable;
//import rx.schedulers.Schedulers;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.io.IOException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//public class DivideTable {
//
//    private Connection sourceConn() throws SQLException {
//        return GenExecutor.getConnection();
//    }
//
//    volatile static String columnNames = null;
//    volatile static ArrayList<Pair<String,String>> columns = null;
//
//    public static void copy(String table, ResultSet rs,Connection connection) throws SQLException {
//        if(columns == null || columnNames == null){
//            synchronized(DivideTable.class){
//                if(columns == null){
//                    columns = new ArrayList<>();
//                    ResultSetMetaData metaData = rs.getMetaData();
//                    for (int i = 0; i < metaData.getColumnCount(); i++) {
//                        String name = metaData.getColumnName(i);
//                        columns.add(Pair.of(name,metaData.getColumnTypeName(i)));
//                    }
//                    columnNames = columns.stream().map(x -> x.getLeft()).collect(Collectors.joining(","));
//                }
//            }
//        }
//        String sql = String.format("insert into %s (%s) values(%s)",table,columnNames,
//                columns.stream().map(x->"?").collect(Collectors.joining(",")));
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)){
//            while (rs.next()){
//                for (int i = 0; i < columns.size(); i++) {
//                    stmt.setObject(i+1,rs.getObject(i+1));
//                }
//                stmt.addBatch();
//            }
//            stmt.executeBatch();
//        }catch (Exception ex){
//            ex.printStackTrace();
//            System.out.println(sql);
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        int batch = 5000;
//        int batchSize = 20000;
//        int threadNum = 10;
//        String table = "t_post";
//        String sourceTable = "huge.post";
//        CountDownLatch latch = new CountDownLatch(batch);
//        ThreadLocal<DataSource> ds = ThreadLocal.withInitial(()->{
//           File file = new File("src/main/java/data/sql/sharding.yml");
//            try {
//                DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(file);
//                return dataSource;
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        });
//
//        AtomicInteger counter = new AtomicInteger(0);
//        long start = System.currentTimeMillis();
//        Observable.range(0, batch)
//                .window(batch / threadNum)
//                .subscribe(o ->
//                        o.subscribeOn(Schedulers.newThread())
//                                .subscribe(batchId -> {
//
//                                    var success = false;
//                                    while (!success) {
//                                        try {
//                                            batchId = counter.getAndIncrement();
//
//
//                                            try (var connection = ds.get().getConnection()) {
//                                                try (var stmt = connection.createStatement()) {
//                                                    var rs = stmt.executeQuery(String.format("select * from %s limit %d,%d", sourceTable, batchId * batchSize, batchSize));
//                                                    try {
//                                                        copy(table, rs, connection);
//                                                    } catch (Exception ex) {
//                                                        ex.printStackTrace();
//                                                        System.out.println(ex.getCause());
//                                                    }
//                                                    rs.close();
//                                                }
//                                                latch.countDown();
//                                                var dt = (System.currentTimeMillis() - start) / 60000.0;
//                                                System.out.format("%d finished. %d/%d, speed=%.2fW/min\n", batchId, batch - latch.getCount(), batch, ((batch - latch.getCount()) * batchSize) / 10000.0 / dt);
//                                                success = true;
//                                            }
//                                        } catch (SQLException throwables) {
//                                            throwables.printStackTrace();
//                                        }
//                                    }
//                                })
//                );
//        latch.await();
//
//    }
//}
