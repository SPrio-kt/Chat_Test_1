package com.kreeti.chatapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        messageList.layoutManager = LinearLayoutManager(this)
        adapter = MessageAdapter(this)
        messageList.adapter = adapter

        btnSend.setOnClickListener {
            App.user = "supriyo"

            val message1 = Message(
                "supriyo",
                "Hi",
                Calendar.getInstance().timeInMillis
            )
            val message2 = Message(
                "Arnab",
                "Hello",
                Calendar.getInstance().timeInMillis
            )
            runOnUiThread {
                adapter.addMessage(message1)
                // scroll the RecyclerView to the last added element
                messageList.scrollToPosition(adapter.itemCount - 1);
                adapter.addMessage(message2)
                // scroll the RecyclerView to the last added element
                messageList.scrollToPosition(adapter.itemCount - 1);
            }
        }
    }
}
