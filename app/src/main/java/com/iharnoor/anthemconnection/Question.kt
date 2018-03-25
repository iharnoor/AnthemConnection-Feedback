package com.iharnoor.anthemconnection

/**
 * Created by hsingh9 on 3/24/2018.
 */
internal class Question(ques: String, username: String, answer: String) {
    private val ques: String
    private val username: String
    private val answer: String
//    init {
//
//    }
    init {
        this.ques = ques
        this.username = username
        this.answer = answer
    }


    override fun toString(): String {
        return "$ques $username $answer"
    }
}