package com.gzeinnumer.mybasepackage.base;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

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
