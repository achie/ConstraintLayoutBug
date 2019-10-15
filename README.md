A sample project that shows a bug with the right/end margin of children TextViews that are in a Compound View/ Custom View.

This works fine in the previous stable version 1.1.3 of ConstraintLayout.

The bug is that when a ConstraintLayout contains a TextView within a custom View, it doesn't seem to respect the parent ConstraintLayout's end margin

####Expected
![Image of expected behavior](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/margins_expected.png)

####Observed
![Image of observed behavior](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/margins_observed.png)

The Sample shows a list of items that alternate between items which respect margins and those which do not.
![Sample app home screen](https://github.com/achie/ConstraintLayoutBug/blob/master/readme/images/sample_app.png)
