# Android-Iframe-Play-Youtube-Video
This repository consist of an android app which play YouTube videos using Iframe.
**Note:** This will play only embed Urls.


**Step# 1**
**Create a layout for Play Youtbe Videos**

        <?xml version="1.0" encoding="utf-8"?>
        <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".MainActivity">

            <WebView
                android:id="@+id/webView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="@android:color/white"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />
        </androidx.constraintlayout.widget.ConstraintLayout>



**Step# 2**

**MainActivity.java**

Initialize **WebView** and **youtubeUrl**(Containing Url)

     private WebView webView;
     String youTubeUrl = "https://www.youtube.com/embed/47yJ2XCRLZs";

Initialize **frameVideo** *for WebView*

    String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" " +
            "src='" + youTubeUrl + "' frameborder=\"0\" allowfullscreen>" +
            "</iframe></body></html>";

**src** attribute contains Youtube's video link

**Regex for Youtube'sUrl**

    String regexYoutUbe = "^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+";

If condition for validate **Embed Url**

    if (youTubeUrl.matches(regexYoutUbe)) {

setting **web client**

    webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        
Finally, **set** JavaScript mode and **load** the data

     WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadData(frameVideo, "text/html", "utf-8");
    }

Otherwise **Toast** it is not valid(embed) Youtube's Url

         else {
                    Toast.makeText(MainActivity.this, "This is other video",
                            Toast.LENGTH_SHORT).show();
                }
        
**Result**

![Video View](https://i.ibb.co/TbzPjd5/device-2019-07-16-140421.png)
![Playing Video](https://i.ibb.co/0y3XyKD/device-2019-07-16-140503.png)

