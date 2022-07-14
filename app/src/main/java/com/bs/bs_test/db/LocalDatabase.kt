package com.bs.bs_test.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bs.bs_test.model.Item

//@Database(entities = [Item::class], version = 1)
abstract class LocalDatabase :RoomDatabase(){

//    abstract fun datadao():datadao
//    companion object{
//        private var INSTANCE:LocalDatabase?=null
//        fun getDatabase(context:Context):LocalDatabase{
//            if (INSTANCE==null){
//                synchronized(this){
//                    INSTANCE = Room.databaseBuilder(context,LocalDatabase::class.java,"DB").build()
//                }
//            }
//            return INSTANCE!!
//        }
//    }
}