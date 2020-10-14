# MyBasePackage

#
#### BaseDao

You can use this Base if you using [Room](https://developer.android.com/training/data-storage/room?hl=id) as your local database.

- Make Base Class
```java
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(T obj);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Long insertIgnore(T obj);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(List<T> objs);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insertIgnoreAll(List<T> objs);

    @Update
    void update(T obj);

    @Update
    int updateAll(List<T> objs);

    @Delete
    void delete(T objs);

    @Delete
    int deleteAll(List<T> objs);
}
```

- Entity Class
```java
@Entity(tableName = "dummy")
public class DummyTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "field1")
    public String field1;

    //Constructor
    
    //Getter Setter
    
}
```

- Use Base Class
```java
@Dao
public abstract class DummyDao implements BaseDao<DummyTable> {

    @Query("SELECT * FROM dummy")
    public abstract List<DummyTable> getAll();

    @Query("DELETE FROM dummy")
    public abstract void truncateData();

    @Query("SELECT COUNT(id) FROM dummy")
    public abstract int getRowCount();
}
```

#
#### BaseListResponse
You cal use this Base if you using [Retrofit](https://square.github.io/retrofit/) on your project ass your `Http Client`.

- Make Base Class
```java
public class BaseListResponse<T> {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("data")
    @Expose
    private List<T> data;
    
    //Constructor
    
    //Getter Setter
}
```

- Make Model Class
```java
public class DataItem{

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;
    
    //Constructor
    
    //Getter Setter
}
```

- Use Base Class
```java
public interface ApiService {
    @GET("/users/{id}")
    Call<BaseListResponse<DataItem>> getData(@Body DataItem dataItem);
}
```

#
#### BaseObjectResponse
You cal use this Base if you using [Retrofit](https://square.github.io/retrofit/) on your project ass your `Http Client`.

- Make Base Class
```java
public class BaseObjectResponse<T> {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("data")
    @Expose
    private T data;
    
    //Constructor
    
    //Getter Setter
}
```

- Make Model Class
```java
public class DataItem{

	@SerializedName("id")
	private int id;

	@SerializedName("name")
	private String name;
    
    //Constructor
    
    //Getter Setter
}
```

- Use Base Class
```java
public interface ApiService {
    @GET("/users/{id}")
    Call<BaseObjectResponse<DataItem>> getData(@Body DataItem dataItem);
}
```

