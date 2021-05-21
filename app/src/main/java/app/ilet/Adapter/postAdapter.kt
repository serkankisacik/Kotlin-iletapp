package app.ilet.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.ilet.Activity.MessageActivity
import app.ilet.Model.Post
import app.ilet.R


class poatAdapter(mcontex : Context,postListt: List<Post>) :
    RecyclerView.Adapter<poatAdapter.ViewHolder>() {
    private val postList: List<Post>
    private var mContex: Context

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var baslik : TextView
        var mesaj: TextView
        var user: TextView
        var root: LinearLayout

        init {
            baslik = v.findViewById(R.id.baslik)
            mesaj = v.findViewById(R.id.post)
            user = v.findViewById(R.id.user)
            root = v.findViewById(R.id.root)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.baslik.setText(postList[position].baslik)
        holder.mesaj.setText(postList[position].mesaj)
        holder.user.setText(postList[position].user)
        holder.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContex, MessageActivity::class.java)
            intent.putExtra("userid", postList[position].userid)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mContex.startActivity(intent)
        })

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return postList.size
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    init {
        postList = postListt
        mContex=mcontex
    }
}