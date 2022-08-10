package com.example.ex_navigationcomponent

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.navigation.fragment.findNavController
import com.example.ex_navigationcomponent.databinding.FragmentDeepLinkBinding

class DeepLinkFragment : Fragment() {
    //view binding
    private var _binding: FragmentDeepLinkBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDeepLinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userName = arguments?.getString("tuananh")
        binding.txtText.text = userName

        pushNotification()

    }

    private fun pushNotification() {
        binding.btnPushNotification.setOnClickListener {
            val args = Bundle()
            args.putString("myArg", binding.edtArg.text.toString().trim())

            val pendingIntent = findNavController().createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.deepLinkFragment)
                .setArguments(args)
                .createPendingIntent()

            val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel("deepLink", "Deep Links", NotificationManager.IMPORTANCE_HIGH)

                )
            }

            val builder = NotificationCompat.Builder(
                requireContext(),"deepLink"
            )
                .setContentTitle("Navigation")
                .setContentText("Deep link to Navigation Component")
                .setSmallIcon(R.drawable.ic_alert_black)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
            notificationManager.notify(0, builder.build())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}