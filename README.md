# Android App demo to launch another app which is hidden from launcher.

## Requirement

We have an master/main app and some other apps (submodules). Master app is visible on Launcher but submodules should be hidden from launcher. Only main app should launch submodules.

## BroadcastReceiver with permission

To accomplish above tasks we have 2 apps:

* MainApp: This app will send broadcast to `SubModulesDemo` app.
* SubModulesDemo: This app has `BroadcastReceiver` implementation and it will launch itself on receiving `onReceive` broadcast.

## Order of installation

The MainApp has custom permission which is used while broadcasting message to submodules. As per [official document (note section)](https://developer.android.com/guide/components/broadcasts#sending-broadcasts-permissions) we must install MainApp first and then SubModulesDemo app.

Check MainApp (AndroidManifest.xml)[MainApp\app\src\main\AndroidManifest.xml] for custom permission.

### Changelog

- April 14th, 2022
  - Updated SubModulesDemo (AndroidManifest.xml)[SubModulesDemo\app\src\main\AndroidManifest.xml] to include full activity name.
  - Added a new button in MainApp. Now we can launch submodule by sending broadcast or by `Package Name` & `Full Activity Name`. Check `launchPackage` method in [MainActivity.java](./MainApp/app/src/main/java/com/vickywords/mainapp/MainActivity.java)