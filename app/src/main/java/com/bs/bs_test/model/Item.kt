package com.bs.bs_test.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

//@Entity(tableName = "homepage")
data class Item(
//        @PrimaryKey(autoGenerate = true) val itemId: Int,
        val description: String,
        val forks_count: Int,
        val full_name: String,
        val language: String,
        val open_issues_count: Int,
        val stargazers_count: Int,
        val updated_at: String,
        val watchers_count: Int,
        val owner: Owner
)