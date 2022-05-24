package com.example.magazin_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(
    private val campaignList: List<Campaign>,
    private val productList: List<Product>,
    val mItemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CAMPAIGN = 1
        const val PRODUCT = 2
    }

    private val mList: List<ListItem> = campaignList.plus(productList)

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    private inner class StoreViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val main_titl: TextView = itemView.findViewById(R.id.main_titl)

        val main_cash: TextView = itemView.findViewById(R.id.main_cash)
        val main_annotation: TextView = itemView.findViewById(R.id.main_annotation)

        fun bind(position: Int) {
            val campaign = mList[position] as Campaign

            Picasso.get().load(campaign.imageUrl).into(imageView)
            main_cash.text = campaign.cashback
            main_annotation.text = campaign.paymentTime
            main_titl.text = campaign.name
        }
    }

    private inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.text_one)
        val price: TextView = itemView.findViewById(R.id.text_two)


        fun bind(position: Int) {
            val product = mList[position] as Product
            Picasso.get().load(product.campaignImageUrl).into(image)
            name.text = product.name
            price.text = product.price

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == CAMPAIGN) {
            return StoreViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_store, parent, false)
            )
        }
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (mList[position].getViewType() == CAMPAIGN) {
            (holder as StoreViewHolder).bind(position)
        } else {
            (holder as ProductViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return mList[position].getViewType()
    }

}








///////////////////////////////////////////////////////////////

/*


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.Item_store, parent, false)

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
*/