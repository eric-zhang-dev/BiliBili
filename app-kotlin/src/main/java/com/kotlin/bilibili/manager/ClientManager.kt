//package com.d.m.system.manager
//
//import com.d.m.system.App
//import com.inuker.bluetooth.library.BluetoothClient
//
//object ClientManager {
//
//    private var mClient: BluetoothClient? = null
//
//    val client: BluetoothClient
//        get() {
//            if (mClient == null) {
//                synchronized(ClientManager::class.java) {
//                    if (mClient == null) {
//                        mClient = BluetoothClient(App.instance)
//                    }
//                }
//            }
//            return mClient!!
//        }
//}
