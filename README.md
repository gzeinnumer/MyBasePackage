# MyBasePackage

#### BaseDao

You can use this `Base` if you using [Room](https://developer.android.com/training/data-storage/room?hl=id) as your local database.

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
You cal use this `Base` if you using [Retrofit](https://square.github.io/retrofit/) on your project as your `Http Client`.

- JSON response example
```json
{
   "status":"1",
   "message":"Success dapat data",
   "total":10,
   "data":[
      {
         "id":1,
         "name":"Zein"
      },
      {
         "id":2,
         "name":"GZeinNumer"
      }
   ]
}
```

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
You can use this `Base` if you using [Retrofit](https://square.github.io/retrofit/) on your project as your `Http Client`.

- JSON response example
```json
{
   "status":"1",
   "message":"Success dapat data",
   "total":10,
   "data":{
      "id":2,
      "name":"GZeinNumer"
   }
}
```

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

#
#### BaseActivity
- Make Base Class
```java
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onShowLoading(){

    }

}
```

- Use Base Class
```java
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onShowLoading();
    }
}
```

#
#### BaseResource
```java
public class BaseResource<T> {

    public enum BaseResourceStatus{
        STATUS_1_SUCCESS,
        STATUS_2_ERROR,
        STATUS_3_EMPTY,
        STATUS_4_INFO,
        STATUS_5_LOGOUT,
        STATUS_6_LOADING
    }

    @NonNull
    final public BaseResourceStatus status;

    @Nullable
    final public T data;

    @Nullable
    final public String message;

    public BaseResource(@NonNull BaseResourceStatus status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> BaseResource<T> success(@NonNull String msg, @Nullable T data) {
        return new BaseResource<>(BaseResourceStatus.STATUS_1_SUCCESS, data, msg);
    }

    public static <T> BaseResource<T> error(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_2_ERROR, null, msg);
    }

    public static <T> BaseResource<T> empty(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_3_EMPTY, null, msg);
    }

    public static <T> BaseResource<T> info(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_4_INFO, null, msg);
    }

    public static <T> BaseResource<T> logout() {
        return new BaseResource<>(BaseResourceStatus.STATUS_5_LOGOUT, null, null);
    }

    public static <T> BaseResource<T> loading() {
        return new BaseResource<>(BaseResourceStatus.STATUS_6_LOADING, null, null);
    }
}
```

---

```
Copyright 2020 M. Fadli Zein
```
