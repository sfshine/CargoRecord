package cn.su.cargorecord.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import cn.su.cargorecord.db.entity.Person

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(person: Person)
}