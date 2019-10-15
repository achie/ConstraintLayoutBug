A sample project that shows a bug with the right/end margin of children TextViews that are in a Compound View/ Custom View.

This works fine in the previous stable version 1.1.3 of ConstraintLayout.


The bug is that when a ConstraintLayout contains a TextView within a custom View, it doesn't seem to respect the parent ConstraintLayout's end margin

#### Expected

![Image of expected behavior](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/margins_expected.png)


#### Observed

![Image of observed behavior](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/margins_observed.png)


The Sample shows a list of items that alternate between items which respect margins and those which do not.
![Sample app home screen](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/sample_app.png)

This is the snippet from the layout xml that has this issue.
This file is located [here](https://github.com/achie/ConstraintLayoutBug/blob/master/app/src/main/res/layout/view_landmark_list_item.xml): 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginStart="16dp"
    android:layout_marginEnd="16dp"
    android:padding="12dp"
    android:background="@drawable/bg_list_item_landmark">
  
    .....

    <TextView
        android:id="@+id/descriptionTv"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:maxLines="2"
        android:ellipsize="end"
        android:textSize="14sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/landmarkIv" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

This layout is inflated as a custom view. [View Code](https://github.com/achie/ConstraintLayoutBug/blob/master/app/src/main/java/com/achie/bug/constraint/LandmarkListItemView.kt)

That is then used by the [adapter](https://github.com/achie/ConstraintLayoutBug/blob/master/app/src/main/java/com/achie/bug/constraint/LandmarksAdapter.kt)

The sample adds each item twice in the list with each one alternating between using the layout directly and binding it's internal views from adapter vs using the custom view as another layout file. The screenshot of this result is shown above.
