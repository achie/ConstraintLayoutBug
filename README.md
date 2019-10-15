A sample project that shows a bug with the right/end margin of children TextViews that are in a Compound View/ Custom View.

This works fine in the previous stable version 1.1.3 of ConstraintLayout.

The bug is that when a ConstraintLayout contains a TextView within a custom View, it doesn't seem to respect the parent ConstraintLayout's end margin

Expected


Observed


The Sample shows a list of items that alternate between items which respect margins and those which do not.