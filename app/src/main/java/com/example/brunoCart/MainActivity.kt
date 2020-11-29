package com.example.brunoCart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brunoCart.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTeaItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var tealist: ArrayList<Tea>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        tealist = ArrayList ()
        addTea()

        teaRecycler.layoutManager = LinearLayoutManager(this)
        teaRecycler.addItemDecoration(DividerItemDecoration(this,1))
        teaRecycler.adapter = TeaAdapter(tealist,this)

    }
    fun addTea() {
        tealist.add(
            Tea( "Darjelling 100g", "€8.50",  "Darjeeling in north east India isn't easy to get to. Even the famous antique train has to wind its way carefully through valleys and around mountains to get there. But the cup of golden Darjeeling tea once you arrive makes it all worthwhile. It's known as the Champagne of teas and we definitely think it's a reason to celebrate.",
                logo = R.drawable.tea1
            )
        )
        tealist.add(
            Tea("Assam 100g","€7.50",  "Imagine a land where elephants and tigers wander freely, and where lush green paddy fields sit under stormy skies.\n" +
                    "\n" +
                    "That place is Assam in North East India. The tea it produces is one of the world's most famous - a rich and strong, deep-amber tea that goes perfectly with brunch or after dinner instead of coffee.",
                logo = R.drawable.tea2
            )
        )
        tealist.add(
            Tea( "Earl Grey 100g","€3.50",  "First created for Prime Minister Charles Grey over 180 years ago, this fresh-tasting and unique blend has become one of the nation’s very favourites. For a full, fragrant Earl Grey experience, our loose leaf variety makes the perfect choice.",
                logo = R.drawable.tea3
            )
        )
        tealist.add(
            Tea( "Lapsang 100g","€9.50",   "There isn't a scent or flavour more distinctive than Lapsang Souchong. It's all down to the pinewood smoke that permeates the tea leaves when they're being dried\n",
                logo = R.drawable.tea4
            )
        )
        tealist.add(
            Tea( "Irish Breakfast 100g","€2.50",  "Irish breakfast has in the past, simply been called 'Irish Tea' and was developed at the turn of the last century for the Irish market. Unlike its fore-runner English Breakfast, Irish Breakfast is much stronger, more intense in taste and bolder in colour. Twinings has created a wonderful blend of African broken pekoe and tasty Sri Lankan broken orange pekoe, and this tea, whilst not widely available in the UK, is extremely popular overseas.\n",
                logo = R.drawable.tea5
            )
        )


    }

    override fun onItemClick(item: Tea, position: Int) {
        val intent = Intent(this, TeaDetailsActivity::class.java)
        intent.putExtra("PRODUCTNAME",item.name)
        intent.putExtra("PRODUCTPRICE", item.price)
        intent.putExtra("PRODUCTDESC",item.description)
        intent.putExtra("PRODUCTLOGO",item.logo.toString())
        startActivity(intent)

    }
}



