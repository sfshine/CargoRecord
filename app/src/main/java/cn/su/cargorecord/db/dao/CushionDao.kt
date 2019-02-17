package cn.su.cargorecord.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import cn.su.cargorecord.db.entity.Cushion

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
@Dao
interface CushionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(cushion: Cushion)
}