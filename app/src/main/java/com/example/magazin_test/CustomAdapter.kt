package com.example.magazin_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Campaign>, val mItemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design_shabl, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val campaign = mList.get(position)


        Picasso.get().load(campaign.imageUrl).into(holder.imageView);



        holder.main_cash.text = campaign.cashback
        holder.main_annotation.text = campaign.paymentTime

        holder.main_titl.text = campaign.name

    }


    override fun getItemCount(): Int {
        return mList.size
    }


    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val main_titl: TextView = itemView.findViewById(R.id.main_titl)

        val main_cash: TextView = itemView.findViewById(R.id.main_cash)
        val main_annotation: TextView = itemView.findViewById(R.id.main_annotation)

        init {
            ItemView.setOnClickListener {
                mList.get(position).id.let { it -> mItemClickListener.onItemClick(it) }
            }
        }
    }
}
