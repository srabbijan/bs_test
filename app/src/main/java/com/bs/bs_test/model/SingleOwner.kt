package com.bs.bs_test.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "singleowner")
data class SingleOwner(
    @PrimaryKey(autoGenerate = true) val itemId: Int,
    var avatar_url: String,
    var bio: String="",
    var blog: String,
    var company: String,
    var followers: Int,
    var following: Int,
    var location: String,
    var login: String,
    var name: String,
    var updated_at: String
)