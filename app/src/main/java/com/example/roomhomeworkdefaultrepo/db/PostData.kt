package com.example.roomhomeworkdefaultrepo.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PostData(
    var title : String,
    var content : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}