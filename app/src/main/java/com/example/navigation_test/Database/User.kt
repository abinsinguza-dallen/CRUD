package com.example.navigation_test.Database

import android.os.Parcel
import android.os.Parcelable

import androidx.room.Entity
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="user_table")
data class User(
    val id :Int,
    val firstName:String,
    val lastName:String,
    val age:Int

) : Parcelable
