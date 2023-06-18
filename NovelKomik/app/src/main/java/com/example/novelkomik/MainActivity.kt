package com.example.novelkomik

import NovelAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NovelAdapter
    private lateinit var secondAdapter: KomikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = NovelAdapter(getItemList(), object : NovelAdapter.OnItemClickListener {
            override fun onItemClick(item: Novel) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("name", item.name)
                    putExtra("image", item.image)
                    putExtra("description", item.description)

                }
                startActivity(intent)
            }
        })

        // Inisialisasi Adapter ke dua
        secondAdapter = KomikAdapter(getItemList2(), object : KomikAdapter.OnItemClickListener {
            override fun onItemClick(item: Komik) {
                val intent = Intent(this@MainActivity, DetailActivity2::class.java).apply {
                    putExtra("name", item.name)
                    putExtra("image", item.image)
                    putExtra("description", item.description)

                }
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Novel -> {
                    recyclerView.adapter = adapter
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Komik -> {
                    recyclerView.adapter = secondAdapter
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }


    private fun getItemList(): List<Novel> {
        val items = mutableListOf<Novel>()
        items.add(
            Novel(
                "Grand Ancestor Bloodline",
                R.drawable.novel1,
                getString(R.string.detail_a)

            )
        )

        items.add(
            Novel(
                "Dimensional Descent",
                R.drawable.novel2,
                getString(R.string.detail_b),

            )
        )
        items.add(
            Novel(
                "ReturnOfTheMountHuaSect",
                R.drawable.novel3,
                getString(R.string.detail_c),

            )
        )
        items.add(
            Novel(
                "ReaperOfTheDriftingMoon",
                R.drawable.novel4,
                getString(R.string.detail_d),

            )
        )
        items.add(
            Novel(
                "ReturnOfTheFrozenPlayer",
                R.drawable.novel5,
                getString(R.string.detail_e),

            )
        )
        items.add(
            Novel(
                "GeniusOfTheUniqueLeague",
                R.drawable.novel6,
                getString(R.string.detail_f),

            )
        )
        items.add(
            Novel(
                "TheDarkMageBackToEnlistment",
                R.drawable.novel7,
                getString(R.string.detail_g),

            )
        )
        items.add(
            Novel(
                "PathOfTheWudang",
                R.drawable.novel8,
                getString(R.string.detail_h),

            )
        )
        items.add(
            Novel(
                "SuperhumanBattlefield",
                R.drawable.novel9,
                getString(R.string.detail_i),

        )
        )
        items.add(
                    Novel(
                "TheBeginningAfterTheEnd",
                R.drawable.novel10,
                getString(R.string.detail_j),

            )
        )
        items.add(
            Novel(
                "TrashOfTheCountFamily",
                R.drawable.novel11,
                getString(R.string.detail_k),

            )
        )
        items.add(
            Novel(
                "NanoMachine",
                R.drawable.novel12,
                getString(R.string.detail_l),

            )
        )
        items.add(
            Novel(
                "SupremacyGame",
                R.drawable.novel13,
                getString(R.string.detail_m),

            )
        )
        items.add(
            Novel(
                "SwordMasterOfTheYoungestSon",
                R.drawable.novel14,
                getString(R.string.detail_n),

            )
        )
        items.add(
            Novel(
                "MyDiscipleAreAllVillain",
                R.drawable.novel15,
                getString(R.string.detail_o)
            )
        )

        return items
    }

    private fun getItemList2(): List<Komik> {
        val items = mutableListOf<Komik>()
        items.add(
            Komik(
                "Eleceed",
                R.drawable.komik1,
                "Kaiden - A mysterious ability user who hides inside the body of a street cat. " +
                        "He is later picked up by Jiwoo after being injured after a fight with another ability user. He has a stubborn and bossy personality. Jiwoo - an energetic and talkative high school boy who loves cats. He is very kind and also seem to have a special ability.",

            )
        )
        items.add(
            Komik(
                "Return Of theNorthern Blade",
                R.drawable.komik2,
                "When the world was plunged into darkness martial artists gathered to form the ‘Northern Heavenly Sect’. " +
                        "With the help of the Northern Heavenly Sect people began to enjoy peace again. However, as time passed the martial artists began to conspire against the ‘Northern Heavenly Sect’, and eventually caused the death of the Sect Leader, Jin Kwan-Ho, destroying the sect with it.",

            )
        )
        items.add(
            Komik(
                "The Max Level Hero Has Returned",
                R.drawable.komik3,
                "The weak prince of an insignificant country, Davey. After becoming comatose, his soul escaped to a temple where the souls of heroes gathered.",

            )
        )
        items.add(
            Komik(
                "SSS class Suicide Hunter",
                R.drawable.komik4,
                "You have awakened an S-Rank skill. But it only works when you die.",

            )
        )
        items.add(
            Komik(
                "Worn And Torn Newbie",
                R.drawable.komik5,
                "15 years remain till termination of service. The ending is known only to me.",

            )
        )
        items.add(
            Komik(
                "Tensei Shitara Slime Datta Ken",
                R.drawable.komik6,
                "A man is stabbed by a robber on the run after pushing his coworker and his coworker's new fiance out of the way. As he lays dying, bleeding on the ground, he hears a voice. This voice is strange and interprets his dying regret of being a virgin by gives him the [Great Sage] unique skill! Is he being made fun of !?!",

            )
        )
        items.add(
            Komik(
                "Reincarnation of the suicidal battle god",
                R.drawable.komik7,
                "A time travel action fantasy of the strongest of mankind. “Even if the disgusting gods gave me this chance, an opportunity is still an opportunity. Since they want to end up dead, I will kill them."

            )
        )
        items.add(
            Komik(
                "Talent Swallowing Magician",
                R.drawable.komik8,
                "Elric Melvinger.\n" +
                        "The sole heir of the prestigious magic family.\n" +
                        "Though he possessed innate talent, he had too much talent, and as such, could not learn magic. However, he then received a blessing left by his ancestors!",

            )
        )
        items.add(
            Komik(
                "lord coin aren't decreasing",
                R.drawable.komik9,
                "???: Alright, let's keep it up and do the heave-ho???: Heave???: Ho???: Heave???: We can heave ho all we want but I think we're all screwed because of that guy.",

            )
        )
        items.add(
            Komik(
                "Archmage Streamer",
                R.drawable.komik10,
                "Jung HyeonWoo had neither ‘Talent’, ‘Money’, or ‘Luck’. “Why can I see the hidden information in the game?” After an electrocution accident, I started being able to see stuff I couldn’t before in the game.",

            )
        )
        items.add(
            Komik(
                "i obtained mythic item",
                R.drawable.komik11,
                "D-Rank non-combat raider becomes a great enemy of god that will save the world with the strongest restoration item.",

            )
        )
        items.add(
            Komik(
                "Standard Of Reincarnation",
                R.drawable.komik12,
                "The greatest martial family, Samion. Daven, a member of the Samion family, is a one-armed martial soldier without a right arm.",

            )
        )
        items.add(
            Komik(
                "dungeon school hunter",
                R.drawable.komik13,
                "An Earth in the 21st century that has fused with another world.",

            )
        )
        items.add(
            Komik(
                "relife player",
                R.drawable.komik14,
                "Noh Eunha. After losing his family and closing off his heart, he just wanted to kill the monsters he loathed.",

            )
        )
        items.add(
            Komik(
                "Solo leveling",
                R.drawable.komik15,
                "10 years ago, after “the Gate” that connected the real world with the monster world opened, some of the ordinary, everyday people received the power to hunt monsters within the Gate.",

            )
        )

        return items
    }
}