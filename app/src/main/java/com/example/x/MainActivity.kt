package com.example.x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.x.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var selectTab = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeLayout: LinearLayout = binding.homeLayout
        val searchLayout: LinearLayout = binding.searchLayout
        val notificationLayout: LinearLayout = binding.notificationLayout
        val profileLayout: LinearLayout = binding.profileLayout
        val messageLayout: LinearLayout = binding.messageLayout
        val grokLayout: LinearLayout = binding.grokLayout

        val homeImage: ImageView = binding.homeIv
        val searchImage: ImageView = binding.searchIv
        val notificationImage: ImageView = binding.notificationIv
        val profileImage: ImageView = binding.profileIv
        val messageImage: ImageView = binding.messageIv
        val grokImage: ImageView = binding.grokIv



        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment::class.java, null)
            .commit()

        homeLayout.setOnClickListener {
            if (selectTab != 1) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, HomeFragment::class.java, null)
                    .commit()

                searchImage.setImageResource(R.drawable.baseline_search_24)
                notificationImage.setImageResource(R.drawable.baseline_notifications_24)
                profileImage.setImageResource(R.drawable.baseline_profile_24)
                messageImage.setImageResource(R.drawable.baseline_chat_24)
                grokImage.setImageResource(R.drawable.baseline_grok_24)


                searchLayout.setBackgroundResource(android.R.color.transparent)
                notificationLayout.setBackgroundResource(android.R.color.transparent)
                profileLayout.setBackgroundResource(android.R.color.transparent)
                messageLayout.setBackgroundResource(android.R.color.transparent)
                grokLayout.setBackgroundResource(android.R.color.transparent)


                homeImage.setImageResource(R.drawable.baseline_home_s_24)
                homeLayout.setBackgroundResource(R.drawable.round_back_home_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                homeLayout.startAnimation(scaleAnimation)

                selectTab = 1
            }
        }

        searchLayout.setOnClickListener {
            if (selectTab != 2) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, SearchFragment::class.java, null)
                    .commit()


                homeImage.setImageResource(R.drawable.baseline_home_24)
                notificationImage.setImageResource(R.drawable.baseline_notifications_24)
                profileImage.setImageResource(R.drawable.baseline_profile_24)
                messageImage.setImageResource(R.drawable.baseline_chat_24)
                grokImage.setImageResource(R.drawable.baseline_grok_24)


                homeLayout.setBackgroundResource(android.R.color.transparent)
                notificationLayout.setBackgroundResource(android.R.color.transparent)
                profileLayout.setBackgroundResource(android.R.color.transparent)
                messageLayout.setBackgroundResource(android.R.color.transparent)
                grokLayout.setBackgroundResource(android.R.color.transparent)


                searchImage.setImageResource(R.drawable.baseline_search_2_24)
                searchLayout.setBackgroundResource(R.drawable.round_back_search_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                searchLayout.startAnimation(scaleAnimation)

                selectTab = 2
            }
        }

        grokLayout.setOnClickListener {
            if (selectTab != 3) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, GrokFragment::class.java, null)
                    .commit()

                homeImage.setImageResource(R.drawable.baseline_home_24)
                searchImage.setImageResource(R.drawable.baseline_search_24)
                profileImage.setImageResource(R.drawable.baseline_profile_24)
                notificationImage.setImageResource(R.drawable.baseline_notifications_24)
                messageImage.setImageResource(R.drawable.baseline_chat_24)



                homeLayout.setBackgroundResource(android.R.color.transparent)
                searchLayout.setBackgroundResource(android.R.color.transparent)
                profileLayout.setBackgroundResource(android.R.color.transparent)
                notificationLayout.setBackgroundResource(android.R.color.transparent)
                messageLayout.setBackgroundResource(android.R.color.transparent)

                grokImage.setImageResource(R.drawable.baseline_grok_2_24)
                grokLayout.setBackgroundResource(R.drawable.round_back_grok_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                notificationLayout.startAnimation(scaleAnimation)

                selectTab = 3
            }
        }

        profileLayout.setOnClickListener {
            if (selectTab != 4) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, ProfileFragment::class.java, null)
                    .commit()



                homeImage.setImageResource(R.drawable.baseline_home_24)
                searchImage.setImageResource(R.drawable.baseline_search_24)
                grokImage.setImageResource(R.drawable.baseline_grok_24)
                notificationImage.setImageResource(R.drawable.baseline_notifications_24)
                messageImage.setImageResource(R.drawable.baseline_chat_24)

                homeLayout.setBackgroundResource(android.R.color.transparent)
                searchLayout.setBackgroundResource(android.R.color.transparent)
                grokLayout.setBackgroundResource(android.R.color.transparent)
                notificationLayout.setBackgroundResource(android.R.color.transparent)
                messageLayout.setBackgroundResource(android.R.color.transparent)


                profileImage.setImageResource(R.drawable.baseline_profile_2_24)
                profileLayout.setBackgroundResource(R.drawable.round_back_profile_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                profileLayout.startAnimation(scaleAnimation)

                selectTab = 4
            }
        }
        notificationLayout.setOnClickListener {
            if (selectTab != 5) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, NotificationFragment::class.java, null)
                    .commit()



                homeImage.setImageResource(R.drawable.baseline_home_24)
                searchImage.setImageResource(R.drawable.baseline_search_24)
                grokImage.setImageResource(R.drawable.baseline_grok_24)
                profileImage.setImageResource(R.drawable.baseline_profile_24)
                messageImage.setImageResource(R.drawable.baseline_chat_24)


                homeLayout.setBackgroundResource(android.R.color.transparent)
                searchLayout.setBackgroundResource(android.R.color.transparent)
                grokLayout.setBackgroundResource(android.R.color.transparent)
                profileLayout.setBackgroundResource(android.R.color.transparent)
                messageLayout.setBackgroundResource(android.R.color.transparent)


                notificationImage.setImageResource(R.drawable.baseline_notifications_s_24)
                notificationLayout.setBackgroundResource(R.drawable.round_back_notification_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                notificationLayout.startAnimation(scaleAnimation)

                selectTab = 5
            }
        }


        messageLayout.setOnClickListener {
            if (selectTab != 6) {

                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, MessageFragment::class.java, null)
                    .commit()


                homeImage.setImageResource(R.drawable.baseline_home_24)
                searchImage.setImageResource(R.drawable.baseline_search_24)
                grokImage.setImageResource(R.drawable.baseline_grok_24)
                profileImage.setImageResource(R.drawable.baseline_profile_24)
                notificationImage.setImageResource(R.drawable.baseline_notifications_24)


                homeLayout.setBackgroundResource(android.R.color.transparent)
                searchLayout.setBackgroundResource(android.R.color.transparent)
                grokLayout.setBackgroundResource(android.R.color.transparent)
                profileLayout.setBackgroundResource(android.R.color.transparent)
                notificationLayout.setBackgroundResource(android.R.color.transparent)

                messageImage.setImageResource(R.drawable.baseline_chat_2_24)
                messageLayout.setBackgroundResource(R.drawable.round_back_message_100)

                val scaleAnimation = ScaleAnimation(
                    0.8f, 1.0f, 1f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f
                )
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                notificationLayout.startAnimation(scaleAnimation)

                selectTab = 6
            }
        }

    }
}